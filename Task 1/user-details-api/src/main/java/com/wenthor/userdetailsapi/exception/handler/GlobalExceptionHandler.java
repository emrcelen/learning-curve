package com.wenthor.userdetailsapi.exception.handler;

import com.wenthor.userdetailsapi.enums.ErrorCodes;
import com.wenthor.userdetailsapi.exception.exceptions.CountryNotFoundException;
import com.wenthor.userdetailsapi.exception.exceptions.UserNotFoundException;
import com.wenthor.userdetailsapi.response.rest.ErrorResponse;
import com.wenthor.userdetailsapi.response.rest.InvalidResponse;
import com.wenthor.userdetailsapi.response.rest.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CountryNotFoundException.class)
    protected ResponseEntity handleCountryNotFoundException(CountryNotFoundException ex, WebRequest request){
        String detail = request.getDescription(false);
        return getResponseEntity(ex.getErrorMessage(),ex.getErrorCode(),detail,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
        String detail = request.getDescription(false);
        return getResponseEntity(ex.getErrorMessage(),ex.getErrorCode(),detail,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        String detail = request.getDescription(false);
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return getInvalidEntity(errors,"Datalar doğrulanamadı, lütfen tekrar istekte bulunun.", ErrorCodes.INVALID_REQUEST,detail, HttpStatus.BAD_REQUEST);
    }
    private ResponseEntity getInvalidEntity(Map<String,String> valid, String message, ErrorCodes errorCode, String detail, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getErrorCode(),errorCode.name(),detail);
        InvalidResponse invalidResponse = new InvalidResponse(errorResponse,valid);
        RestResponse<InvalidResponse> restResponse = RestResponse.error(invalidResponse,message,httpStatus);
        return new ResponseEntity<>(restResponse, httpStatus);
    }
    private ResponseEntity getResponseEntity(String message, ErrorCodes errorCode, String detail, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getErrorCode(),message,detail);
        RestResponse<ErrorResponse> restResponse = RestResponse.error(errorResponse,errorCode.name(),httpStatus);
        return new ResponseEntity<>(restResponse, httpStatus);
    }
}
