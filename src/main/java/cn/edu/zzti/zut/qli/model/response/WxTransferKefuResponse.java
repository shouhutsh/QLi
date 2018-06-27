package cn.edu.zzti.zut.qli.model.response;

import cn.edu.zzti.zut.qli.model.base.BaseModel;
import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxTransferKefuResponse extends WxBaseResponse {

    @XStreamAlias("TransInfo")
    protected TransInfo transInfo;

    public WxTransferKefuResponse() {
        this.msgType = MessageType.TRANSFER_CUSTOMER_SERVICE.getCode();
    }

    public TransInfo getTransInfo() {
        return transInfo;
    }

    public void setTransInfo(TransInfo transInfo) {
        this.transInfo = transInfo;
    }

    @XStreamAlias("TransInfo")
    public static class TransInfo implements BaseModel {

        @XStreamAlias("KfAccount")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String kfAccount;

        public String getKfAccount() {
            return kfAccount;
        }

        public void setKfAccount(String kfAccount) {
            this.kfAccount = kfAccount;
        }
    }
}
