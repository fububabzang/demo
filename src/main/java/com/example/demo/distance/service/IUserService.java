package com.example.demo.distance.service;

import com.example.demo.distance.dataObject.User;

import java.util.List;

public interface IUserService {

    List<User> selectUser(double minlng , double maxlng , double minlat , double maxlat);

    int insertUser(User user);
}
