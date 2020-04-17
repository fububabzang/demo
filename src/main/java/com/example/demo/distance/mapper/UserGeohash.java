package com.example.demo.distance.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGeohash {

    int insertUserGeohash(UserGeohash userGeohash);
}
