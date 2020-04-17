package com.example.demo.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-26 10:37
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class ThisTestController extends ThisTestClass {


    @GetMapping("/getMyResult")
    public String getMyResult(){

        String v1 = "abcde";
        String v2 = "123456";

      return  getMap.getResult(v1 , v2);

    }
    @GetMapping("/admin.html")
    public String admin(){

        String v1 = "3333";
        String v2 = "dddd";
        log.info(getMap.getResult(v1 , v2));
        return  getMap.getResult(v1 , v2);

    }

}
