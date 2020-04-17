package com.example.demo.distance.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.RealmeJSONResult;
import com.example.demo.distance.dataObject.User;
import com.example.demo.distance.service.IUserService;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 14:49
 **/
@RestController
@RequestMapping("/distance")
public class DistanceController extends BaseController{



    @Autowired
    private IUserService userService;

    /**
     * 4     * 获取附近 x 米的人
     * 5     *
     * 6     * @param distance 搜索距离范围 单位km
     * 7     * @param userLng  当前用户的经度
     * 8     * @param userLat  当前用户的纬度
     * 9
     */
    @GetMapping("/nearby")
    public RealmeJSONResult nearBySearch(@RequestParam("distance") double distance,
                               @RequestParam("userLng") double userLng,
                               @RequestParam("userLat") double userLat) {
        //1.获取外接正方形
        Rectangle rectangle = getRectangle(distance, userLng, userLat);
        //2.获取位置在正方形内的所有用户
        List<User> users = userService.selectUser(rectangle.getMinX(), rectangle.getMaxX(), rectangle.getMinY(), rectangle.getMaxY());
        //3.剔除半径超过指定距离的多余用户
        users = users.stream()
                .filter(a -> getDistance(a.getLongitude(), a.getLatitude(), userLng, userLat) <= distance)
                .collect(Collectors.toList());
        return RealmeJSONResult.ok(users);
    }

    @PostMapping("/addUser")
    public RealmeJSONResult addUser(@RequestParam("name") String name , @RequestParam("address") String address) throws Exception {
        String larLng = getLarLng(address);
        int count  = larLng.lastIndexOf(",");
        String lon = larLng.substring(0, count);
        double longitude = Double.parseDouble(lon);
        String lat = larLng.substring(count + 1, larLng.length());
        double latitude = Double.parseDouble(lat);

        User user = new User();
        user.setName(name);
        user.setLongitude(longitude);
        user.setLatitude(latitude);
        user.setAddress(address);
        return RealmeJSONResult.ok(userService.insertUser(user));
    }



}
