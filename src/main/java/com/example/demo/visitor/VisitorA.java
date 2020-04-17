package com.example.demo.visitor;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:23
 **/
public class VisitorA implements Visitor {

    @Override
    public void visit(VistorEmpleeA vistorEmpleeA) {
        System.out.println("工程师: " + vistorEmpleeA.name + "的代码量:" + vistorEmpleeA.getCodeLines());
    }

    @Override
    public void visit(VistorEmpleeB vistorEmpleeB) {
        System.out.println("经理:" + vistorEmpleeB.name + "新产品数量" + vistorEmpleeB.getProducts());
    }
}
