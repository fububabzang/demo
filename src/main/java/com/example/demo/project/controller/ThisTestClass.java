package com.example.demo.project.controller;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-26 10:18
 **/
public class ThisTestClass {

    ExecutorService executorService = Executors.newFixedThreadPool(8);

    public String toSubString(String v1 , String v2) throws InterruptedException {
        return v1.substring(2)+v2.substring(1);
    }

    interface doCallable{
        String getResult(String v1 , String v2);
    }

    public doCallable getMap = (String v1 , String v2) ->{
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return toSubString(v1 , v2);
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        executorService.execute(futureTask);
        String strResult = "";
        try {
            strResult = futureTask.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return strResult;
    };



}


