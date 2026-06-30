package com.study.springboot3.common;


import lombok.Getter;

/**
 * @author yinyin
 * @create 2021/07/22 下午 6:04
 */

@Getter
public enum ResultCodeEnum {
    SUCCESS(true,200,"成功"),
    UNKNOW_REASON(false,500,"失败"),

    LOGIN_SUCCESS(true,200,"登录成功"),
    LOGOUT_SUCCESS(true,200,"退出成功"),
    VALID_FAIL(false,415,"验证码不正确"),
    UNKNOW_ACCOUNT(false,412,"账户不存在"),
    LOCKED_ACCOUNT(false,411,"账户被锁定"),
    PASSWOED_ERROR(false,413,"用户名或密码不正确"),
    BAD_SQL_GRAMMAR(false,211,"sql错误"),
    JSON_PARSE_ERROR(false,212,"json解析失败"),
    JWT_PARSE_ERROR(false,213,"jwt解析异常"),
    JWT_EXPIRED_ERROR(false,214,"jwt过期"),
    PARAM_ERROR(false,511,"参数不正确"),
    METHODARGUMENT_NOTVALIDATE(false,555,"参数校验不通过"),
    FILE_UPLOAD_ERROR(false,321,"文件上传失败"),
    GET_METHOD_ERROR(false,255,"操作日志--->获取方法失败"),
    PIC_GENERATION_ERROR(false,301,"验证码图片生成失败");


    private Boolean success;
    private Integer code;
    private String messages;

    ResultCodeEnum(Boolean success, Integer code, String messages){
        this.success=success;
        this.code=code;
        this.messages=messages;

    }
}