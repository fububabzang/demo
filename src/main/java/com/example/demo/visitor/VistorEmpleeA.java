package com.example.demo.visitor;

import java.util.Random;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:18
 **/
public class VistorEmpleeA extends VistorEmplee {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public VistorEmpleeA(String name) {
        super(name);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
