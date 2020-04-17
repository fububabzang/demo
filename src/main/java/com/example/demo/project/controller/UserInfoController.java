package com.example.demo.project.controller;

import com.example.demo.common.result.ResultVO;
import com.example.demo.project.dataObject.UserInfo;
import com.example.demo.project.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:38
 **/
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @PostMapping("/addUserInfo")
    public int addUserInfo(@RequestBody @Validated UserInfo userInfo){
        //return RealmeJSONResult.ok(userInfoService.addUserInfo(userInfo));
        //return ResultVO.ok(userInfoService.addUserInfo(userInfo));
        //return ResultVO.error("测试失败");
        return userInfoService.addUserInfo(userInfo);
    }
}
