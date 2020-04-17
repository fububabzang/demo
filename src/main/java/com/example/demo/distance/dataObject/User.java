package com.example.demo.distance.dataObject;

import lombok.Data;

import java.util.Date;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 14:55
 **/
@Data
public class User {

    private Integer id;

    private String name;

    private Double longitude;

    private Double latitude;

    private String address;

    private Date createTime;
}
