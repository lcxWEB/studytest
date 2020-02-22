package com.star.design.principle.dependencyinversion;/**
 * Created by lcx on 2018/11/22.
 */

/**
 * @Author: lcx
 * @Date: 2018/11/22 12:38
 * @Description: TODO
 */

public class Test {

    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.studyJavaCourse();
        geely.studyFrontCourse();

        System.out.println(1/0.0);
        System.out.println(-1/0.0);


        System.out.println(0.0/0.0);
        System.out.println(0.0/0);
        System.out.println(0/0.0);

        int x = Math.round(3.2f);
        System.out.println(x);
        int y = (int) Math.round(3.9);
        System.out.println(y);
        System.out.println(StrictMath.round(5.8));
    }
}
