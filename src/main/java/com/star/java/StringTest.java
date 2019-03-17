package com.star.java;

/**
 * @Author: lcx
 * @Date: 2019/3/3 10:19
 * @Description:
 */

public class StringTest {

    public static void main(String[] args) {
        String a = "AAA";
        String b = new String("AAA");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a);
        System.out.println(b);
    }

}
