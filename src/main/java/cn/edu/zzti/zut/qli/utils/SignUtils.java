package cn.edu.zzti.zut.qli.utils;

import cn.edu.zzti.zut.qli.model.annotations.SignField;
import cn.edu.zzti.zut.qli.model.sign.BaseSignModel;

import java.lang.reflect.Field;
import java.util.List;

public final class SignUtils {

    private final String token;

    public SignUtils(String token) {
        this.token = token;
    }

    public boolean verifySign(BaseSignModel signModel, String signature) {
        return sign(signModel).equals(signature);
    }

    public String sign(BaseSignModel signModel) {
        List<Field> fields = ObjectUtils.getAllFields(signModel.getClass(),
                                (f) -> null != f.getAnnotation(SignField.class));
        String[] arr = new String[fields.size() + 1];
        arr[0] = token;
        int i = 1;
        for (Field f: fields) {
            f.setAccessible(true);
            try {
                arr[i++] = String.valueOf(f.get(signModel));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return CryptUtils.sha1(arr);
    }
}
