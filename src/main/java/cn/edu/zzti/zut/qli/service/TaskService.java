package cn.edu.zzti.zut.qli.service;

import cn.edu.zzti.zut.qli.config.WechatConfig;
import cn.edu.zzti.zut.qli.model.constants.WxUrlConstants;
import cn.edu.zzti.zut.qli.utils.Sender;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatConfig wechatConfig;

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public boolean flushAccessToken() {
        try {
            String request = String.format("grant_type=client_credential&appid=%s&secret=%s", wechatConfig.getAppId(), wechatConfig.getSecret());
            HttpGet get = Sender.buildGetRequest(WxUrlConstants.ACCESS_TOKEN, request);
            JSONObject json = JSONObject.parseObject(Sender.send(get));
            wechatConfig.setAccessToken(json.getString("access_token"));
            return true;
        } catch (Exception e) {
            logger.error("刷新AccessToken失败！", e);
            return false;
        }
    }
}
