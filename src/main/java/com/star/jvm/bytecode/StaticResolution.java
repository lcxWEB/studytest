package com.star.jvm.bytecode;

import com.star.jvm.polymorphic.StaticDispatch;

/**
 * @Author: lcx
 * @Date: 2019/3/9 19:17
 * @Description:
 */

public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }

}
