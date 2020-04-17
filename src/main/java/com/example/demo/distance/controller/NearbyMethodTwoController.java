package com.example.demo.distance.controller;

import com.example.demo.common.RealmeJSONResult;
import com.example.demo.distance.dataObject.User;
import com.example.demo.distance.dataObject.UserGeohash;
import com.example.demo.distance.service.RedisNearByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 17:59
 **/
@RestController
@RequestMapping("/nearbyMethodTwo")
public class NearbyMethodTwoController extends BaseController{

    @Autowired
    private RedisNearByService redisNearByService;

    @PostMapping("/addUser")
    public boolean add(@RequestParam("name") String name , @RequestParam("address") String address) throws Exception {
        UserGeohash userGeohash = new UserGeohash();
        String larLng = getLarLng(address);
        int count  = larLng.lastIndexOf(",");
        String lon = larLng.substring(0, count);
        double longitude = Double.parseDouble(lon);
        String lat = larLng.substring(count + 1, larLng.length());
        double latitude = Double.parseDouble(lat);
        userGeohash.setName(name);
        userGeohash.setLongitude(longitude);
        userGeohash.setLatitude(latitude);
        return redisNearByService.save(userGeohash.setCreateTime(LocalDateTime.now()));
    }

    /**
     * 获取附近x米的人
     *
     * @param distance 距离范围 单位km
     * @param userLng  当前经度
     * @param userLat  当前纬度
     * @return json
     */
    @GetMapping("/nearby")
    public RealmeJSONResult nearBySearch(@RequestParam("distance") double distance,
                                         @RequestParam("userLng") double userLng,
                                         @RequestParam("userLat") double userLat) {
        //return redisNearByService.nearBySearch(distance,userLng,userLat);
        return RealmeJSONResult.ok(redisNearByService.nearBySearch(distance,userLng,userLat));
    }
}
