package com.example.demo.controller;

import com.example.demo.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-27 14:43
 **/
@RestController
@RequestMapping("/doTest")
public class MyTestController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/setTest")
    public String setTest() {
        return !redisService.setRedisOfTimeOut("123456", "aaaaaaaa", 30L) ? "false" : "ture";
    }
}

class WaitTest {

    public synchronized void testWait() {

        System.out.println("---------------start---------------");


        try {
            wait();
            System.out.println("********************************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------end---------------");


    }

    public static void main(String[] args) throws InterruptedException {
        final WaitTest waitTest = new WaitTest();

        for (int i = 0; i < 5; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    waitTest.testWait();
                }
            }).start();

        }
        synchronized (waitTest) {
            waitTest.notify();
        }
        Thread.sleep(3000);
        System.out.println("//////////////////////////");

        synchronized (waitTest) {
            waitTest.notifyAll();
        }

    }

}
