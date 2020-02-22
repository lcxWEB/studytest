package com.star.jvm.classloading;

/**
 * @Author: lcx
 * @Date: 2019/3/3 17:09
 * @Description:
 */

public class Test {

    static {
        i = 0;
        // System.out.println(i); // 非法前向引用
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(Test.i);
    }

}
