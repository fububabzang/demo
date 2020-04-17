package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-27 10:25
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    @Override
    public String createToken() {
        String value = "";
        String key = "";
        try {
            value = String.valueOf(UUID.randomUUID());
            key = String.valueOf(new Random(8));
            redisService.setRedisOfTimeOut(key, value, 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            token = request.getParameter("token");
            if (StringUtils.isEmpty(token)){
                throw new NullPointerException();
            }
        }
        if (!redisService.checkValueByKey(token)){
            throw new NullPointerException();
        }
        boolean remove = redisService.deleteRedisByKey(token);
        if (!remove){
            throw new NullPointerException();
        }
        return true;
    }
}
