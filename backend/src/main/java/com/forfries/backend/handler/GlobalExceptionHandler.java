package com.forfries.backend.handler;

import com.forfries.backend.entity.Result;
import com.forfries.backend.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public Result AllExceptionHandler(RuntimeException ex){
        log.error("其他异常：{}", ex.getMessage());
        return Result.fail(ex.getMessage());
    }

    @ExceptionHandler
    public Result BaseExceptionHandler(BaseException ex){
        log.error("基础异常：{}", ex.getMessage());
        return Result.fail(ex.getMessage());
    }

}
