package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-27 10:07
 **/
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    //写入缓存
    public boolean setRedis(final String key, Object value) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    //写入换成并设置有效时间
    public boolean setRedisOfTimeOut(final String key, Object value, Long timeOut) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key , value , timeOut , TimeUnit.SECONDS);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //判断redis中是否有value
    public boolean checkValueByKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    //读取缓存
    public Object getRedisValue(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    //查出缓存
    public boolean deleteRedisByKey(final String key){
        if (checkValueByKey(key)){
            Boolean delete = redisTemplate.delete(key);
            return delete;
        }
        return false;
    }
}
