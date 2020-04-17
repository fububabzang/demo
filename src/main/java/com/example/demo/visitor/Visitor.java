package com.example.demo.visitor;

//访问者的接口(抽象类)
//它里面的方法数就是访问者元素的数量
public interface Visitor {

    // 访问工程师类型
    void visit(VistorEmpleeA vistorEmpleeA);

    // 访问经理类型
    void visit(VistorEmpleeB vistorEmpleeB);
}
