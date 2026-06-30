package com.study.springboot3.exception;

import com.study.springboot3.common.ResultCodeEnum;
import lombok.Data;

@Data
public class EnkiException extends RuntimeException{
    private Integer code;

    public EnkiException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public EnkiException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessages());
        this.code= resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ProjectException{" +
                "code=" + code +
                ",message=" + this.getMessage() +
                '}';
    }
}