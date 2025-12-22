package com.trallkong.csitsbackend.debug;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 处理所有未捕获的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("未处理的异常", ex);
        ErrorResponse errorResponse = ErrorResponse.builder(
                ex,
                HttpStatus.INTERNAL_SERVER_ERROR,
                "服务器内部错误"
        ).build();
        return ResponseEntity.status(500).body(errorResponse);
    }

    // 处理所有运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        log.error("运行时异常", ex);
        ErrorResponse errorResponse = ErrorResponse.builder(
                ex,
                HttpStatus.INTERNAL_SERVER_ERROR,
                "运行时异常"
        ).build();
        return ResponseEntity.status(500).body(errorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error("实体未找到异常", ex);
        ErrorResponse errorResponse = ErrorResponse.builder(
                ex,
                HttpStatus.NOT_FOUND,
                "实体未找到"
        ).build();
        return ResponseEntity.status(404).body(errorResponse);
    }
}
