package cn.edu.zzti.zut.qli.model.base;

public class XStreamMediaIdConverter extends XStreamCDataConverter {
    @Override
    public String toString(Object obj) {
        return "<MediaId>" + super.toString(obj) + "</MediaId>";
    }
}
