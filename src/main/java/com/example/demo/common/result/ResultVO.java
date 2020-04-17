package com.example.demo.common.result;

import lombok.Getter;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:52
 **/
@Getter
public class ResultVO<T> {
    /**
     * 状态码，比如200代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultVO(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public static ResultVO ok(Object data) {
        return new ResultVO(data);
    }

    public static ResultVO error(String msg) {
        return new ResultVO(msg);
    }
}
