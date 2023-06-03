package com.wenthor.userdetailsapi.response.rest;

import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RestResponse<T> {
    private final String message;
    private final T payload;
    private final int statusCode;
    private final String responseDate;
    private final boolean isSuccess;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

    public RestResponse(String message, T payload, HttpStatus status, boolean isSuccess) {
        this.message = message;
        this.payload = payload;
        this.statusCode = status.value();
        this.responseDate = formatter.format(new Date());
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }
    public T getPayload() {
        return payload;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public String getDate() {
        return responseDate;
    }
    public boolean isSuccess() {
        return isSuccess;
    }


    public static <T> RestResponse<T> of(T t, String message, HttpStatus status) {
        return new RestResponse<>(message, t, status, true);
    }
    public static <T> RestResponse<T> create(T t, String message) {
        return new RestResponse<>(message, t, HttpStatus.CREATED, true);
    }
    public static <T> RestResponse<T> error(T t, String message, HttpStatus status) {
        return new RestResponse<>(message, t, status, false);
    }
}
