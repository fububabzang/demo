package com.example.demo.project.controller;

import javafx.scene.chart.BubbleChart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-09 14:06
 **/
@RestController
@RequestMapping
public class TestController {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder stringBuilder = new StringBuilder("123.456");

        stringBuilder.append(".46546546");

        String bbc = stringBuilder.substring(0,2);
        System.out.println(bbc);

        System.out.println(stringBuilder);

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\do_service\\settings.xml"));

        try {
            System.out.println(dataInputStream.read());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1,2);

        Map<Integer, Integer> map1 = new HashMap<>();

        map1.put(2,3);
        map1.put(3,3);
        map1.put(4,3);


        Map<String, String> map2 = Collections.synchronizedMap(new HashMap<String, String>());
        map2.put("123456" , "789456");

        System.out.println(map2);

        map.putAll(map1);

        System.out.println(map);

    }



}



