package com.example.demo.distance.service.impl;

import com.example.demo.distance.dataObject.User;
import com.example.demo.distance.mapper.UserMapper;
import com.example.demo.distance.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 15:00
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUser(double minlng , double maxlng , double minlat , double maxlat) {
        return userMapper.selectUser(minlng, maxlng, minlat, maxlat);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
