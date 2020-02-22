package com.star.jvm.classloading;

/**
 * @Author: lcx
 * @Date: 2019/2/23 15:47
 * @Description:
 */

public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public static final String HELLO = "Hello";

    static {
        value = 456;
    }

}
