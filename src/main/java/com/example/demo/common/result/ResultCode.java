package com.example.demo.common.result;

import lombok.Getter;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:56
 **/
@Getter
public enum  ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
