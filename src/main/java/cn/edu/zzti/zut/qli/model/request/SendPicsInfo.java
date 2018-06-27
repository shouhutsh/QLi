package cn.edu.zzti.zut.qli.model.request;

import cn.edu.zzti.zut.qli.model.base.BaseModel;
import cn.edu.zzti.zut.qli.model.base.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("SendPicsInfo")
public class SendPicsInfo implements BaseModel {

    @XStreamAlias("PicList")
    protected final List<Item> picList = new ArrayList<>();

    @XStreamAlias("Count")
    private Long count;

    public List<Item> getPicList() {
        return picList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @XStreamAlias("item")
    public static class Item implements BaseModel {

        @XStreamAlias("PicMd5Sum")
        @XStreamConverter(value = XStreamCDataConverter.class)
        private String picMd5Sum;

        public String getPicMd5Sum() {
            return picMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            this.picMd5Sum = picMd5Sum;
        }
    }
}
