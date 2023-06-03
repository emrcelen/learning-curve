package com.wenthor.userdetailsapi.response.rest;

public class ErrorResponse {
    private final String errorCode;
    private final String errorMessage;
    private final String detail;

    public ErrorResponse(String errorCode, String errorMessage, String detail) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detail = detail;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public String getDetail() {
        return detail;
    }
}
