package com.alvin.compfest.exception;

public class ApiException {
    private final String message;
    private final String status = "error";
    private final int code;

    public ApiException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

}
