package cn.edu.zzti.zut.qli.service.impl;

import cn.edu.zzti.zut.qli.model.enums.ErrorCode;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import cn.edu.zzti.zut.qli.model.exception.BizException;
import cn.edu.zzti.zut.qli.model.request.WxRequest;
import cn.edu.zzti.zut.qli.model.response.WxBaseResponse;
import cn.edu.zzti.zut.qli.model.response.WxTextResponse;
import cn.edu.zzti.zut.qli.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public WxBaseResponse doRoute(WxRequest request) throws BizException {
        WxBaseResponse response = null;
        try {
            MessageType messageType = MessageType.byCode(request.getMsgType());
            if (null == messageType) {
                logger.info("消息类型解析失败！", request.getMsgType());
                return null;
            }
            WxTextResponse textResponse = new WxTextResponse();
            textResponse.setContent(request.getContent());
            response = textResponse;
        } catch (Exception e) {
            logger.error("路由处理失败！", e);
            throw new BizException(ErrorCode.SYSTEM_ERROR);
        } finally {
            setCommon(request, response);
        }
        return response;
    }

    private void setCommon(WxRequest request, WxBaseResponse response) {
        if (null != response) {
            response.setToUserName(request.getFromUser());
            response.setFromUserName(request.getToUser());
            response.setCreateTime(System.currentTimeMillis() / 1000L);
        }
    }
}
