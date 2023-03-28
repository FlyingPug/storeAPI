package com.dron.storeAPI.controller;

import com.dron.storeAPI.exception.BadInput;
import com.dron.storeAPI.exception.ProductNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> unknownError(HttpServletRequest request, Exception ex) {
        return handleCustomException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(BadInput.class)
    public ResponseEntity<Map<String, Object>> badInput(HttpServletRequest request, Exception ex) {
        return handleCustomException(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Map<String, Object>> productNotFound(HttpServletRequest request, Exception ex) {
        return handleCustomException(HttpStatus.NOT_FOUND, ex);
    }


    protected Map<String, Object> body(HttpStatus status, Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", LocalDateTime.now());
        map.put("status", status.value());
        map.put("message", exception.getMessage());
        return map;
    }

    protected ResponseEntity<Map<String, Object>> handleCustomException(HttpStatus status, Exception exception) {
        return ResponseEntity.status(status).body(body(status, exception));
    }
}