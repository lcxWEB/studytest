package com.star.jvm.classloading;

/**
 * @Author: lcx
 * @Date: 2019/2/23 16:07
 * @Description:
 */

public interface ISub extends ISup {

    String SUB = "SUB Interface";

    // 接口中不能使用静态代码块
    // static {
    //
    // }

    void test();

    public static void main(String[] args) {
        System.out.println(SUB);
    }

}
