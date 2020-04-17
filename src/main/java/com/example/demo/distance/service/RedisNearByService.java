package com.example.demo.distance.service;

import com.example.demo.distance.dataObject.UserGeohash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * redis附近的人解决方案
 *
 * @author larscheng
 * @date 2019/12/9 19:17
 */
@Service
public class RedisNearByService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final static String KEY = "user_info";


    public boolean save(UserGeohash user) {
        String name = user.getName();
        Point point = new Point(user.getLongitude(), user.getLatitude());
        System.out.println(name);
        System.out.println(point);
        RedisGeoCommands.GeoLocation<String> stringGeoLocation = new RedisGeoCommands.GeoLocation<>(name, point);
        Long flag = redisTemplate.opsForGeo().add(KEY, new RedisGeoCommands.GeoLocation<>(name, point));
        return flag != null && flag > 0;
    }

    /**
     * 根据当前位置获取附近指定范围内的用户
     * @param distance 指定范围 单位km ，可根据{@link org.springframework.data.geo.Metrics} 进行设置
     * @param userLng 用户经度
     * @param userLat 用户纬度
     * @return
     */
    public List<UserGeohash> nearBySearch(double distance, double userLng, double userLat) {
        List<UserGeohash> users = new ArrayList<>();
        GeoResults<RedisGeoCommands.GeoLocation<Object>> reslut = redisTemplate.opsForGeo()
                .radius(KEY, new Circle(new Point(userLng, userLat), new Distance(distance, Metrics.KILOMETERS)),
                        RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                                .includeDistance()
                                .includeCoordinates().sortAscending());
        List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> content = reslut.getContent();
        content.forEach(a-> users.add(
                new UserGeohash().setDistance(a.getDistance().getValue())
                .setLatitude(a.getContent().getPoint().getX())
                .setLongitude(a.getContent().getPoint().getY())
                .setName(a.getContent().getName().toString())));

        System.out.println("------------reslut------------");
        System.out.println(reslut);
        System.out.println("------------content------------");
        System.out.println(content);
        System.out.println("------------users------------");
        System.out.println(users);

        return users;
    }
}
