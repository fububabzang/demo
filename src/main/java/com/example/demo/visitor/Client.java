package com.example.demo.visitor;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:30
 **/
public class Client {

    public static void main(String[] args) {
        BusinessReport businessReport = new BusinessReport();

        System.out.println("码农的----------------");
        businessReport.showReport(new VisitorA());
        System.out.println("经理的---------------");
        businessReport.showReport(new VisitorB());
        System.out.println("-----------------");
        businessReport.showReport(new VisitorC());
    }
}
