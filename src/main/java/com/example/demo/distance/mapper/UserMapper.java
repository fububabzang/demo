package com.example.demo.distance.mapper;

import com.example.demo.distance.dataObject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUser(@Param("minlng") double minlng, @Param("maxlng") double maxlng,
                          @Param("minlat") double minlat, @Param("maxlat") double maxlat);

    int insertUser(User user);
}
