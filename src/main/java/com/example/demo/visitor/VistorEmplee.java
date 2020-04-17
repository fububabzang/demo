package com.example.demo.visitor;

import java.util.Random;

/**
 * @program: demo
 * @description: 元素基类
 * @author: realme
 * @create: 2020-03-12 15:13
 **/
public abstract class VistorEmplee {

    public String name;

    public int kpi;

    public VistorEmplee(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    public abstract void accept(Visitor visitor);
}
