package cn.edu.zzti.zut.qli.model.response;

import cn.edu.zzti.zut.qli.model.base.XStreamMediaIdConverter;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxImageResponse extends WxBaseResponse {

    @XStreamAlias("Image")
    @XStreamConverter(value = XStreamMediaIdConverter.class)
    private String mediaId;

    public WxImageResponse() {
        this.msgType = MessageType.IMAGE.getCode();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
