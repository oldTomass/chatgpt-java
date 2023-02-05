package com.hjm.common;

import cn.hutool.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(Exception.class) // 拦截所有RuntimeException
    public ResponseEntity<String> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.HTTP_BAD_REQUEST).body("Maybe your balance is not enough or Check your internet");
    }
}
