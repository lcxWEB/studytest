package com.star.thinkInJava.c9interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    private int a = 0;

    private void test() {

    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.foo(); // 打印：“InterfaceA foo”
        classA.bar(); // 打印：“AbstractClassA bar”
        classA.foo1();

        char c = '汉';
        System.out.println(c);

        Collections.synchronizedList(new ArrayList<>());

    }
}