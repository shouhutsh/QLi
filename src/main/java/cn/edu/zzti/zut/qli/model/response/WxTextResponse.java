package cn.edu.zzti.zut.qli.model.response;

import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxTextResponse extends WxBaseResponse {

    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;

    public WxTextResponse() {
        this.msgType = MessageType.TEXT.getCode();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
