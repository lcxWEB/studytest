package com.star.thinkInJava.c5initandclean;

public class A extends B {

    static {
        System.out.println("静态块");
    }
    // public static A t1 = new A();
    // public static A t2 = new A();


    {
        System.out.println("构造块");
    }

}