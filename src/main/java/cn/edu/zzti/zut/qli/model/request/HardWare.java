package cn.edu.zzti.zut.qli.model.request;

import cn.edu.zzti.zut.qli.model.base.BaseModel;
import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("HardWare")
public class HardWare implements BaseModel {
    /**
     * 消息展示，目前支持myrank(排行榜)
     */
    @XStreamAlias("MessageView")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String messageView;
    /**
     * 消息点击动作，目前支持ranklist(点击跳转排行榜)
     */
    @XStreamAlias("MessageAction")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String messageAction;

    public String getMessageView() {
        return messageView;
    }

    public void setMessageView(String messageView) {
        this.messageView = messageView;
    }

    public String getMessageAction() {
        return messageAction;
    }

    public void setMessageAction(String messageAction) {
        this.messageAction = messageAction;
    }
}
