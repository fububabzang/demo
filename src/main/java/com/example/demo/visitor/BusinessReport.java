package com.example.demo.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: realme
 * @create: 2020-03-12 15:27
 **/
public class BusinessReport {

    private List<VistorEmplee> vistorEmpleeList = new LinkedList<>();

    public BusinessReport() {
        vistorEmpleeList.add(new VistorEmpleeB("经理-A"));
        vistorEmpleeList.add(new VistorEmpleeA("工程师-A"));
        vistorEmpleeList.add(new VistorEmpleeA("工程师-B"));
        vistorEmpleeList.add(new VistorEmpleeA("工程师-C"));
        vistorEmpleeList.add(new VistorEmpleeB("经理-B"));
        vistorEmpleeList.add(new VistorEmpleeA("工程师-D"));
    }

    public void showReport(Visitor visitor){
        for (VistorEmplee v:vistorEmpleeList) {
            v.accept(visitor);
        }
    }
}
