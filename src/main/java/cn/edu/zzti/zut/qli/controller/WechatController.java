package cn.edu.zzti.zut.qli.controller;

import cn.edu.zzti.zut.qli.config.WechatConfig;
import cn.edu.zzti.zut.qli.model.enums.EncryptType;
import cn.edu.zzti.zut.qli.model.request.WxRequest;
import cn.edu.zzti.zut.qli.model.response.WxBaseResponse;
import cn.edu.zzti.zut.qli.model.sign.VerifyTokenSign;
import cn.edu.zzti.zut.qli.service.RouteService;
import cn.edu.zzti.zut.qli.utils.CryptUtils;
import cn.edu.zzti.zut.qli.utils.SignUtils;
import cn.edu.zzti.zut.qli.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wechat/portal")
public class WechatController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatConfig wechatConfig;
    @Autowired
    private RouteService routeService;

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(
            @RequestParam(name = "signature") String signature,
            @RequestParam(name = "timestamp") String timestamp,
            @RequestParam(name = "nonce") String nonce,
            @RequestParam(name = "echostr") String echostr) {
        logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);
        SignUtils signUtils = new SignUtils(wechatConfig.getToken());
        VerifyTokenSign token = new VerifyTokenSign(timestamp, nonce);
        if (signUtils.verifySign(token, signature)) {
            return echostr;
        }
        return "非法请求";
    }

    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(@RequestBody String requestBody,
                       @RequestParam String signature,
                       @RequestParam String timestamp,
                       @RequestParam String nonce,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        logger.info("\n接收微信请求：[signature=[{}], encType=[{}], msgSignature=[{}], timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                signature, encType, msgSignature, timestamp, nonce, requestBody);

        SignUtils signUtils = new SignUtils(wechatConfig.getToken());
        CryptUtils cryptUtils = new CryptUtils(wechatConfig);

        VerifyTokenSign token = new VerifyTokenSign(timestamp, nonce);
        if (!signUtils.verifySign(token, signature)) {
            logger.warn("验签失败！");
            return "success";
        }
        WxRequest request = XmlUtils.xml2Bean(WxRequest.class, requestBody);
        EncryptType encryptType = EncryptType.byCode(encType);
        if (null != encryptType) {
            String decrypt = cryptUtils.decrypt(request.getEncrypt());
            logger.info("\n解密后报文：[\n{}\n]", decrypt);
            request = XmlUtils.xml2Bean(WxRequest.class, cryptUtils.decrypt(request.getEncrypt()));
        }

        String out = "success";
        try {
            WxBaseResponse response = routeService.doRoute(request);
            if (null != response) {
                out = XmlUtils.bean2Xml(response);
                if (null != encryptType) {
                    out = cryptUtils.encrypt(out);
                }
            }
        } catch (Exception e) {
            logger.error("路由失败！", e);
        }
        logger.debug("\n组装回复信息：{}", out);
        return out;
    }
}
