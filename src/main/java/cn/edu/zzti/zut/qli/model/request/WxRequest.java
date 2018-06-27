package cn.edu.zzti.zut.qli.model.request;

import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxRequest {

    ///////////////////////
    // 以下都是微信推送过来的消息的xml的element所对应的属性
    ///////////////////////

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String toUser;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String fromUser;

    @XStreamAlias("CreateTime")
    private Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String msgType;

    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;

    @XStreamAlias("MenuId")
    private Long menuId;

    @XStreamAlias("MsgId")
    private Long msgId;

    @XStreamAlias("Encrypt")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String encrypt;

    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String picUrl;

    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String mediaId;

    @XStreamAlias("Format")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String format;

    @XStreamAlias("ThumbMediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String thumbMediaId;

    @XStreamAlias("Location_X")
    private Double locationX;

    @XStreamAlias("Location_Y")
    private Double locationY;

    @XStreamAlias("Scale")
    private Double scale;

    @XStreamAlias("Label")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String label;

    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String title;

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String description;

    @XStreamAlias("Url")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String url;

    @XStreamAlias("Event")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String event;

    @XStreamAlias("EventKey")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String eventKey;

    @XStreamAlias("Ticket")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String ticket;

    @XStreamAlias("Latitude")
    private Double latitude;

    @XStreamAlias("Longitude")
    private Double longitude;

    @XStreamAlias("Precision")
    private Double precision;

    @XStreamAlias("Recognition")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String recognition;

    ///////////////////////////////////////
    // 群发消息返回的结果
    ///////////////////////////////////////
    /**
     * 群发的结果
     */
    @XStreamAlias("Status")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String status;
    /**
     * group_id下粉丝数；或者openid_list中的粉丝数
     */
    @XStreamAlias("TotalCount")
    private Integer totalCount;
    /**
     * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，filterCount = sentCount + errorCount
     */
    @XStreamAlias("FilterCount")
    private Integer filterCount;
    /**
     * 发送成功的粉丝数
     */
    @XStreamAlias("SentCount")
    private Integer sentCount;
    /**
     * 发送失败的粉丝数
     */
    @XStreamAlias("ErrorCount")
    private Integer errorCount;

    ///////////////////////////////////////
    // 客服会话管理相关事件推送
    ///////////////////////////////////////
    /**
     * 创建或关闭客服会话时的客服帐号
     */
    @XStreamAlias("KfAccount")
    private String kfAccount;
    /**
     * 转接客服会话时的转入客服帐号
     */
    @XStreamAlias("ToKfAccount")
    private String toKfAccount;
    /**
     * 转接客服会话时的转出客服帐号
     */
    @XStreamAlias("FromKfAccount")
    private String fromKfAccount;

    ///////////////////////////////////////
    // 卡券相关事件推送
    ///////////////////////////////////////
    @XStreamAlias("CardId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String cardId;

    @XStreamAlias("FriendUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String friendUserName;

    @XStreamAlias("IsGiveByFriend")
    private Integer isGiveByFriend; // 是否为转赠，1代表是，0代表否

    @XStreamAlias("UserCardCode")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String userCardCode;

    @XStreamAlias("OldUserCardCode")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String oldUserCardCode;

    @XStreamAlias("OuterId")
    private Integer outerId;

    /**
     * 用户删除会员卡后可重新找回，当用户本次操作为找回时，该值为1，否则为0
     */
    @XStreamAlias("IsRestoreMemberCard")
    private String isRestoreMemberCard;

    /**
     * <pre>
     * 领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加Addcard接口中自定义该字段的字符串值。
     * 核销卡券时：开发者发起核销时传入的自定义参数，用于进行核销渠道统计
     * 另外：
     * 官网文档中，微信卡券>>卡券事件推送>>2.7 进入会员卡事件推送 user_view_card
     * OuterStr：商户自定义二维码渠道参数，用于标识本次扫码打开会员卡来源来自于某个渠道值的二维码
     * </pre>
     */
    @XStreamAlias("OuterStr")
    private String outerStr;

    /**
     * 是否转赠退回，0代表不是，1代表是。
     */
    @XStreamAlias("IsReturnBack")
    private String isReturnBack;

    /**
     * 是否是群转赠，0代表不是，1代表是。
     */
    @XStreamAlias("IsChatRoom")
    private String isChatRoom;

    /**
     * 核销来源。支持开发者统计API核销（FROM_API）、公众平台核销（FROM_MP）、卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）
     */
    @XStreamAlias("ConsumeSource")
    private String consumeSource;

    /**
     * 门店名称，当前卡券核销的门店名称（只有通过自助核销和买单核销时才会出现该字段）
     */
    @XStreamAlias("LocationName")
    private String locationName;

    /**
     * 核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）
     */
    @XStreamAlias("StaffOpenId")
    private String staffOpenId;

    /**
     * 自助核销时，用户输入的验证码
     */
    @XStreamAlias("VerifyCode")
    private String verifyCode;

    /**
     * 自助核销时，用户输入的备注金额
     */
    @XStreamAlias("RemarkAmount")
    private String remarkAmount;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.10 库存报警事件card_sku_remind
     * Detail：报警详细信息
     * </pre>
     */
    @XStreamAlias("Detail")
    private String detail;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBonus：变动的积分值
     * </pre>
     */
    @XStreamAlias("ModifyBonus")
    private String modifyBonus;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.9 会员卡内容更新事件 update_member_card
     * ModifyBalance：变动的余额值
     * </pre>
     */
    @XStreamAlias("ModifyBalance")
    private String modifyBalance;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * TransId：微信支付交易订单号（只有使用买单功能核销的卡券才会出现）
     * </pre>
     */
    @XStreamAlias("TransId")
    private String transId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * LocationId：门店ID，当前卡券核销的门店ID（只有通过卡券商户助手和买单核销时才会出现）
     * </pre>
     */
    @XStreamAlias("LocationId")
    private String locationId;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * Fee：实付金额，单位为分
     * </pre>
     */
    @XStreamAlias("Fee")
    private String fee;

    /**
     * <pre>
     * 官网文档中，微信卡券>>卡券事件推送>>2.6 买单事件推送 User_pay_from_pay_cell
     * OriginalFee：应付金额，单位为分
     * </pre>
     */
    @XStreamAlias("OriginalFee")
    private String originalFee;

    @XStreamAlias("ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo = new ScanCodeInfo();

    @XStreamAlias("SendPicsInfo")
    private SendPicsInfo sendPicsInfo = new SendPicsInfo();

    @XStreamAlias("SendLocationInfo")
    private SendLocationInfo sendLocationInfo = new SendLocationInfo();

    ///////////////////////////////////////
    // 门店审核事件推送
    ///////////////////////////////////////
    /**
     * UniqId
     * 商户自己内部ID，即字段中的sid
     */
    @XStreamAlias("UniqId")
    private String storeUniqId;

    /**
     * PoiId
     * 微信的门店ID，微信内门店唯一标示ID
     */
    @XStreamAlias("PoiId")
    private String poiId;

    /**
     * Result
     * 审核结果，成功succ 或失败fail
     */
    @XStreamAlias("Result")
    private String result;

    /**
     * msg
     * 成功的通知信息，或审核失败的驳回理由
     */
    @XStreamAlias("msg")
    private String msg;

    ///////////////////////////////////////
    // 微信认证事件推送
    ///////////////////////////////////////
    /**
     * ExpiredTime
     * 资质认证成功/名称认证成功: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     * 年审通知: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期，需尽快年审
     * 认证过期失效通知: 有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证
     */
    @XStreamAlias("ExpiredTime")
    private Long expiredTime;
    /**
     * FailTime
     * 失败发生时间 (整形)，时间戳
     */
    @XStreamAlias("FailTime")
    private Long failTime;
    /**
     * FailReason
     * 认证失败的原因
     */
    @XStreamAlias("FailReason")
    private String failReason;


    ///////////////////////////////////////
    // 微信硬件平台相关事件推送
    ///////////////////////////////////////
    /**
     * 设备类型，目前为"公众账号原始ID"
     */
    @XStreamAlias("DeviceType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String deviceType;

    /**
     * 设备ID，第三方提供
     */
    @XStreamAlias("DeviceID")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String deviceId;

    /**
     * 微信用户账号的OpenID
     */
    @XStreamAlias("OpenID")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String openId;

    @XStreamAlias("HardWare")
    private HardWare hardWare = new HardWare();

    /**
     * 请求类型：0：退订设备状态；1：心跳；（心跳的处理方式跟订阅一样）2：订阅设备状态
     */
    @XStreamAlias("OpType")
    private Integer opType;

    /**
     * 设备状态：0：未连接；1：已连接
     */
    @XStreamAlias("DeviceStatus")
    private Integer deviceStatus;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Integer filterCount) {
        this.filterCount = filterCount;
    }

    public Integer getSentCount() {
        return sentCount;
    }

    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getToKfAccount() {
        return toKfAccount;
    }

    public void setToKfAccount(String toKfAccount) {
        this.toKfAccount = toKfAccount;
    }

    public String getFromKfAccount() {
        return fromKfAccount;
    }

    public void setFromKfAccount(String fromKfAccount) {
        this.fromKfAccount = fromKfAccount;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public Integer getIsGiveByFriend() {
        return isGiveByFriend;
    }

    public void setIsGiveByFriend(Integer isGiveByFriend) {
        this.isGiveByFriend = isGiveByFriend;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public String getOldUserCardCode() {
        return oldUserCardCode;
    }

    public void setOldUserCardCode(String oldUserCardCode) {
        this.oldUserCardCode = oldUserCardCode;
    }

    public Integer getOuterId() {
        return outerId;
    }

    public void setOuterId(Integer outerId) {
        this.outerId = outerId;
    }

    public String getIsRestoreMemberCard() {
        return isRestoreMemberCard;
    }

    public void setIsRestoreMemberCard(String isRestoreMemberCard) {
        this.isRestoreMemberCard = isRestoreMemberCard;
    }

    public String getOuterStr() {
        return outerStr;
    }

    public void setOuterStr(String outerStr) {
        this.outerStr = outerStr;
    }

    public String getIsReturnBack() {
        return isReturnBack;
    }

    public void setIsReturnBack(String isReturnBack) {
        this.isReturnBack = isReturnBack;
    }

    public String getIsChatRoom() {
        return isChatRoom;
    }

    public void setIsChatRoom(String isChatRoom) {
        this.isChatRoom = isChatRoom;
    }

    public String getConsumeSource() {
        return consumeSource;
    }

    public void setConsumeSource(String consumeSource) {
        this.consumeSource = consumeSource;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStaffOpenId() {
        return staffOpenId;
    }

    public void setStaffOpenId(String staffOpenId) {
        this.staffOpenId = staffOpenId;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getRemarkAmount() {
        return remarkAmount;
    }

    public void setRemarkAmount(String remarkAmount) {
        this.remarkAmount = remarkAmount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getModifyBonus() {
        return modifyBonus;
    }

    public void setModifyBonus(String modifyBonus) {
        this.modifyBonus = modifyBonus;
    }

    public String getModifyBalance() {
        return modifyBalance;
    }

    public void setModifyBalance(String modifyBalance) {
        this.modifyBalance = modifyBalance;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getOriginalFee() {
        return originalFee;
    }

    public void setOriginalFee(String originalFee) {
        this.originalFee = originalFee;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

    public String getStoreUniqId() {
        return storeUniqId;
    }

    public void setStoreUniqId(String storeUniqId) {
        this.storeUniqId = storeUniqId;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getFailTime() {
        return failTime;
    }

    public void setFailTime(Long failTime) {
        this.failTime = failTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public HardWare getHardWare() {
        return hardWare;
    }

    public void setHardWare(HardWare hardWare) {
        this.hardWare = hardWare;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}
