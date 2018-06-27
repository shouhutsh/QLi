package cn.edu.zzti.zut.qli.model.enums;

public enum EncryptType {

    AES("aes", "AES加密"),
    ;
    private final String code;
    private final String desc;

    EncryptType(String code, String desc) {
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

    public static EncryptType byCode(String code) {
        for (EncryptType t: EncryptType.values()) {
            if (t.equals(code)) {
                return t;
            }
        }
        return null;
    }
}
