package com.yeyu.exception;

import com.yeyu.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler
//    public Result handleException(Exception e){
//        return Result.error("系统异常，请联系管理员！");
//    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        String message = e.getMessage();
        int i = message.indexOf("Duplicate");
        String errMsg = message.substring(i);
        String[] split = errMsg.split(" ");
        return Result.error(split[2] + "已存在，请更换后重试！");
    }
}
