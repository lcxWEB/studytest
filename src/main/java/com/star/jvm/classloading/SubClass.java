package com.star.jvm.classloading;

/**
 * @Author: lcx
 * @Date: 2019/2/23 15:48
 * @Description:
 */

public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    public static int c = value;


    public static void main(String[] args) {
        System.out.println(SubClass.c);
    }

}
