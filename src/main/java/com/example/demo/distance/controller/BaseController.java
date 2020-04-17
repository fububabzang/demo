package com.example.demo.distance.controller;

import com.alibaba.fastjson.JSONObject;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Rectangle;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-04-16 15:34
 **/
public class BaseController {

    private SpatialContext spatialContext = SpatialContext.GEO;

    public Rectangle getRectangle(double distance, double userLng, double userLat) {
        return spatialContext.getDistCalc()
                .calcBoxByDistFromPt(spatialContext.makePoint(userLng, userLat),
                        distance * DistanceUtils.KM_TO_DEG, spatialContext, null);
    }

    //地球半径常量，km
    private static final double EARTH_RADIUS = 6378.137;

    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double radLat1 = rad(latitude1);
        double radLat2 = rad(latitude2);
        double a = radLat1 - radLat2;
        double b = rad(longitude1) - rad(longitude2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000) / 10000.0;
        return distance;
    }

    /**
     * 角度转弧度
     *
     * @param d
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public String getLarLng(String address) throws Exception {

        Map<String , Double> thisMap = new HashMap<>();

        String ak = "GFqxkVV8PNcyGMWosEoIytagVAtKlHF6";

        String addressUrl = "http://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + ak + "&callback=showLocation";

        URL url = new URL(addressUrl);

        InputStream inputStream = url.openStream();

        String string = IOUtils.toString(inputStream);

        int len = string.length();

        String substring = string.substring(27, len - 1);

        JSONObject jsonObject = JSONObject.parseObject(substring);

        String status = jsonObject.getString("status");
        Double lng = 0.0;
        Double lat = 0.0;
        if (status.equals("0")) {
            lng = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lng");
            thisMap.put("lng" , lng);
            lat = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lat");
            thisMap.put("lat" , lat);
        }
        return String.valueOf(thisMap.get("lng") + "," + thisMap.get("lat"));
    }

    public static double[] getGpsRange(double longitude, double latitude, double rangeDis) {
        double dlng = 2 * Math.asin(Math.sin(rangeDis / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        //角度转为弧度
        dlng = dlng * 180 / Math.PI;
        double dlat = rangeDis / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        return new double[]{minlng, maxlng, minlat, maxlat};
    }
}
