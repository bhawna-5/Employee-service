package com.bhawna.employeeservice.response;

public class ApiResponse<T> extends BaseResponse {

    private T data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(T data) {
        super();
        this.data = data;
    }

    public ApiResponse(boolean success, String message) {
        super(success, message);
    }

    public ApiResponse(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}