package com.wenthor.userdetailsapi.enums;

public enum ErrorCodes {
    INVALID_REQUEST("INV-0001"),
    USER_NOT_FOUND_LIST("UNFL-0001"),
    COUNTRY_NOT_FOUND("CNF-0001");

    private final String errorCode;

    ErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
