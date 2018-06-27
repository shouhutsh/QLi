package cn.edu.zzti.zut.qli.model.sign;

import cn.edu.zzti.zut.qli.model.annotations.SignField;

public class VerifyTokenSign implements BaseSignModel {

    @SignField
    private final String timestamp;

    @SignField
    private final String nonce;

    public VerifyTokenSign(String timestamp, String nonce) {
        this.timestamp = timestamp;
        this.nonce = nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNonce() {
        return nonce;
    }
}
