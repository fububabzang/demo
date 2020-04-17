package com.example.demo.visitor;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:39
 **/
public class VisitorC implements Visitor {

    @Override
    public void visit(VistorEmpleeA vistorEmpleeA) {
        System.out.println("C工程师: " + vistorEmpleeA.name + "的KPI是:" + vistorEmpleeA.kpi);
    }

    @Override
    public void visit(VistorEmpleeB vistorEmpleeB) {
        System.out.println("C经理:" + vistorEmpleeB.name + "新产品数量" + vistorEmpleeB.getProducts());
    }
}
