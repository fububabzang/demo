package com.example.demo.common.result;

import lombok.Getter;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:51
 **/
@Getter
public class APIException extends RuntimeException {

    private int code;

    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
