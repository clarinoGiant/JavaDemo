package com.demo.annotation;

public class MyAnnotationDemo {

    @MyAnnotation(value = "456", name = "wangwu")
    public void print()
    {
        System.out.println("call print()");
    }
}
