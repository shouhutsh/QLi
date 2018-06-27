package cn.edu.zzti.zut.qli.model.response;

import cn.edu.zzti.zut.qli.model.base.XStreamMediaIdConverter;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxVoiceResponse extends WxBaseResponse {

    @XStreamAlias("Voice")
    @XStreamConverter(value = XStreamMediaIdConverter.class)
    private String mediaId;

    public WxVoiceResponse() {
        this.msgType = MessageType.VOICE.getCode();
    }
}
