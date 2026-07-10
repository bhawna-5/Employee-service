package com.bhawna.employeeservice.response;

import java.io.Serializable;

public abstract class BaseResponse implements Serializable {

    private boolean success;
    private String message;
    private String errorCode;
    private Long serverTime;

    public BaseResponse() {
        this.success = true;
        this.message = "Success";
        this.serverTime = System.currentTimeMillis() / 1000;
    }

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.serverTime = System.currentTimeMillis() / 1000;
    }

    public BaseResponse(boolean success, String errorCode, String message) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.serverTime = System.currentTimeMillis() / 1000;
    }

    // getters and setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
