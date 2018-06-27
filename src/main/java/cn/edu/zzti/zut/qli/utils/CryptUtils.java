package cn.edu.zzti.zut.qli.utils;

import cn.edu.zzti.zut.qli.config.WechatConfig;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public final class CryptUtils {

    private final String appId;
    private final String token;
    private final byte[] aesKey;

    private static final int BLOCK_SIZE = 32;

    public CryptUtils(WechatConfig config) {
        this.appId = config.getAppId();
        this.token = config.getToken();
        this.aesKey = Base64.decodeBase64(config.getAesKey() + "=");
    }

    public String encrypt(String plainText) {
        // 加密
        String encryptedXml = encrypt(genRandomStr(), plainText);

        // 生成安全签名
        String timeStamp = Long.toString(System.currentTimeMillis() / 1000L);
        String nonce = genRandomStr();

        String signature = sha1(token, timeStamp, nonce, encryptedXml);
        return generateXml(encryptedXml, signature, timeStamp, nonce);
    }

    /**
     * 对明文进行加密.
     *
     * @param plainText 需要加密的明文
     * @return 加密后base64编码的字符串
     */
    protected String encrypt(String randomStr, String plainText) {
        byte[] randomStringBytes = randomStr.getBytes(StandardCharsets.UTF_8);
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] bytesOfSizeInNetworkOrder = number2BytesInNetworkOrder(plainTextBytes.length);
        byte[] appIdBytes = appId.getBytes(StandardCharsets.UTF_8);

        // randomStr + networkBytesOrder + text + appid
        byte[] unencrypted = ByteUtils.concat(
                randomStringBytes,
                bytesOfSizeInNetworkOrder,
                plainTextBytes,
                appIdBytes
        );

        // ... + pad: 使用自定义的填充方式对明文进行补位填充
        byte[] padBytes = PKCS7Encode(unencrypted.length);
        unencrypted = ByteUtils.concat(unencrypted, padBytes);

        try {
            // 设置加密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

            // 加密
            byte[] encrypted = cipher.doFinal(unencrypted);

            // 使用BASE64对加密后的字符串进行编码
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String cipherText) {
        byte[] original;
        byte[] networkOrder;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(2, key_spec, iv);
            networkOrder = Base64.decodeBase64(cipherText);
            original = cipher.doFinal(networkOrder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String xmlContent;
        String from_appid;
        try {
            byte[] bytes = PKCS7Decode(original);
            networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int xmlLength = bytesNetworkOrder2Number(networkOrder);
            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), StandardCharsets.UTF_8);
            from_appid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), StandardCharsets.UTF_8);
        } catch (Exception var8) {
            throw new RuntimeException(var8);
        }
        if (!from_appid.equals(appId)) {
            throw new RuntimeException("AppID不正确");
        } else {
            return xmlContent;
        }
    }

    public static String sha1(String... arr) {
        if (StringUtils.isAnyEmpty(arr)) {
            throw new IllegalArgumentException("非法请求参数，有部分参数为空 : " + Arrays.toString(arr));
        } else {
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (String s: arr) {
                sb.append(s);
            }
            return DigestUtils.sha1Hex(sb.toString());
        }
    }

    private static byte[] PKCS7Encode(int count) {
        // 计算需要填充的位数
        int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (amountToPad == 0) {
            amountToPad = BLOCK_SIZE;
        }
        // 获得补位所用的字符
        char padChr = chr(amountToPad);
        String tmp = new String();
        for (int index = 0; index < amountToPad; index++) {
            tmp += padChr;
        }
        return tmp.getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] PKCS7Decode(byte[] decrypted) {
        int pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    /**
     * 将数字转化成ASCII码对应的字符，用于对明文进行补码
     *
     * @param a 需要转化的数字
     * @return 转化得到的字符
     */
    private static char chr(int a) {
        byte target = (byte) (a & 0xFF);
        return (char) target;
    }

    /**
     * 生成xml消息
     *
     * @param encrypt   加密后的消息密文
     * @param signature 安全签名
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return 生成的xml字符串
     */
    private static String generateXml(String encrypt, String signature,
                                      String timestamp, String nonce) {
        String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
                + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
                + "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n"
                + "</xml>";
        return String.format(format, encrypt, signature, timestamp, nonce);
    }

    /**
     * 随机生成16位字符串
     */
    private static String genRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 将一个数字转换成生成4个字节的网络字节序bytes数组
     */
    private static byte[] number2BytesInNetworkOrder(int number) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (number & 0xFF);
        orderBytes[2] = (byte) (number >> 8 & 0xFF);
        orderBytes[1] = (byte) (number >> 16 & 0xFF);
        orderBytes[0] = (byte) (number >> 24 & 0xFF);
        return orderBytes;
    }

    private static int bytesNetworkOrder2Number(byte[] bytesInNetworkOrder) {
        int sourceNumber = 0;
        for(int i = 0; i < 4; ++i) {
            sourceNumber <<= 8;
            sourceNumber |= bytesInNetworkOrder[i] & 255;
        }
        return sourceNumber;
    }
}
