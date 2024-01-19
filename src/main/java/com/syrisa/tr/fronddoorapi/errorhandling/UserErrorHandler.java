package com.syrisa.tr.fronddoorapi.errorhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
@ControllerAdvice
public class UserErrorHandler {
    @ExceptionHandler(value={IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException e, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), e.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleOtherStateException(Exception e, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), e.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
