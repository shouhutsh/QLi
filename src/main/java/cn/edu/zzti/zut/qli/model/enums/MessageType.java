package cn.edu.zzti.zut.qli.model.enums;

public enum MessageType {
    TEXT("text", "文本消息"),
    IMAGE("image", "图片消息"),
    VOICE("voice", "语音消息"),
    VIDEO("video", "视频消息"),
    MUSIC("music", "音乐消息"),
    NEWS("news", "图文消息（点击跳转到外链）"),
    MPNEWS("mpnews", "图文消息（点击跳转到图文消息页面）"),
    FILE("file", "发送文件（CP专用）"),
    TEXTCARD("textcard", "发送文件（CP专用）"),
    WXCARD("wxcard", "卡券消息"),
    TRANSFER_CUSTOMER_SERVICE("transfer_customer_service", "转发到客服的消息"),
    ;

    private final String code;
    private final String desc;

    MessageType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public boolean equals(String code) {
        return this.code.equals(code);
    }

    public static MessageType byCode(String code) {
        for (MessageType t: MessageType.values()) {
            if (t.equals(code)) {
                return t;
            }
        }
        return null;
    }
}
