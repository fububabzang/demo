package com.example.demo.project.service.impl;

import com.example.demo.project.dataObject.UserInfo;
import com.example.demo.project.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:39
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return 1;
    }
}
