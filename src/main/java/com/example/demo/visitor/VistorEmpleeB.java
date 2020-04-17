package com.example.demo.visitor;

import java.util.Random;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:21
 **/
public class VistorEmpleeB extends VistorEmplee {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public VistorEmpleeB(String name) {
        super(name);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
