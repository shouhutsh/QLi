package cn.edu.zzti.zut.qli.service;

import cn.edu.zzti.zut.qli.model.exception.BizException;
import cn.edu.zzti.zut.qli.model.request.WxRequest;
import cn.edu.zzti.zut.qli.model.response.WxBaseResponse;

public interface RouteService {

    WxBaseResponse doRoute(WxRequest request) throws BizException;
}
