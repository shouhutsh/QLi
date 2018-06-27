package cn.edu.zzti.zut.qli.model.exception;

import cn.edu.zzti.zut.qli.model.enums.ErrorCode;

public class BizException extends Exception {

    private String respCode;
    private String respMessage;

    public BizException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getDesc());
    }

    public BizException(String respCode, String respMessage) {
        super(respMessage);

        this.respCode = respCode;
        this.respMessage = respMessage;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }
}
