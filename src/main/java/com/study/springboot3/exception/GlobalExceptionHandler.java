package com.study.springboot3.exception;

import com.study.springboot3.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class  GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        e.printStackTrace();
        return Result.error();
    }

    @ExceptionHandler(EnkiException.class)
    @ResponseBody
    public Result handler(EnkiException e){
        e.printStackTrace();
        return Result.error().message(e.getMessage()).code(e.getCode());
    }
    //处理参数校验不通过异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        ObjectError error = result.getAllErrors().stream().findFirst().get();
        log.error("实体校验异常 -------------{}",error.getDefaultMessage());
        return Result.error().message(error.getDefaultMessage());
    }
}