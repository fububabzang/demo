package com.example.demo.project.dataObject;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-10 14:34
 **/
@Data
public class UserInfo {

    @NotNull(message = "用户Id不能为空")
    private Integer userId;

    @NotNull(message = "用户姓名不能为空")
    @Size(max = 6 , min = 4 , message = "username长度在4-6个字符之间")
    private String username;

    @NotNull(message = "用户密码不能为空")
    @Size(max = 8 , min = 4 , message = "password长度在4-6个字符之间")
    private String password;
}
