package com.example.demo.redis;


import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    //创建token
    String createToken();

    //检查token
    boolean checkToken(HttpServletRequest request);
}
