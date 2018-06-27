package cn.edu.zzti.zut.qli.model.response;

import cn.edu.zzti.zut.qli.model.base.BaseModel;
import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import cn.edu.zzti.zut.qli.model.enums.MessageType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("xml")
public class WxNewsResponse extends WxBaseResponse {

    @XStreamAlias("Articles")
    protected final List<Item> articles = new ArrayList<>();
    @XStreamAlias("ArticleCount")
    protected int articleCount;

    public WxNewsResponse() {
        this.msgType = MessageType.NEWS.getCode();
    }

    public void addArticle(Item item) {
        this.articles.add(item);
        this.articleCount = this.articles.size();
    }

    @XStreamAlias("item")
    public static class Item implements BaseModel {
        private static final long serialVersionUID = -4971456355028904754L;

        @XStreamAlias("Title")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String title;

        @XStreamAlias("Description")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String description;

        @XStreamAlias("PicUrl")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String picUrl;

        @XStreamAlias("Url")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String url;

        public static long getSerialVersionUID() {
            return serialVersionUID;
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

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
