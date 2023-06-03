package com.wenthor.userdetailsapi.exception.exceptions;


import com.wenthor.userdetailsapi.enums.ErrorCodes;

public class UserNotFoundException extends RuntimeException {
    private final ErrorCodes errorCode;
    private final String errorMessage;

    public UserNotFoundException(ErrorCodes errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
