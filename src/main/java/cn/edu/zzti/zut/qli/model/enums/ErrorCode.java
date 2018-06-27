package cn.edu.zzti.zut.qli.model.enums;

public enum ErrorCode {
    SYSTEM_SUCCESS("0000", "成功"),

    SYSTEM_ERROR("9999", "系统异常"),
    ;

    private final String code;
    private final String desc;

    ErrorCode(String code, String desc) {
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

    public static ErrorCode byCode(String code) {
        for (ErrorCode t: ErrorCode.values()) {
            if (t.equals(code)) {
                return t;
            }
        }
        return null;
    }
}
