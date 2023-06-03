package com.wenthor.userdetailsapi.response.rest;

import java.util.Map;

public class InvalidResponse {
    private final ErrorResponse errorResponse;
    private final Map<String,String> validation;

    public InvalidResponse(ErrorResponse errorResponse, Map<String, String> validation) {
        this.errorResponse = errorResponse;
        this.validation = validation;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
    public Map<String, String> getValidation() {
        return validation;
    }
}
