package com.birprojedaha.asistan.partner.btcturk;

import java.io.Serializable;
import java.util.StringJoiner;

public class BaseResponse implements Serializable {
    private boolean success;
    private String code;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", " {", "}")
                .add("success=" + success)
                .add("code='" + code + "'")
                .add("message='" + message + "'")
                .toString();
    }
}
