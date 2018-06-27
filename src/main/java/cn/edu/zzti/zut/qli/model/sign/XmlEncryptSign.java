package cn.edu.zzti.zut.qli.model.sign;

import cn.edu.zzti.zut.qli.model.annotations.SignField;

public class XmlEncryptSign {

    @SignField
    private final String timeStamp;
    @SignField
    private final String nonce;
    @SignField
    private final String cipherText;

    public XmlEncryptSign(String timeStamp, String nonce, String cipherText) {
        this.timeStamp = timeStamp;
        this.nonce = nonce;
        this.cipherText = cipherText;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    public String getCipherText() {
        return cipherText;
    }
}
