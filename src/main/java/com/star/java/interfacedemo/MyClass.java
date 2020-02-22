package com.star.java.interfacedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-02-18 15:25
 */
public class MyClass implements MyInterface, MyInterface1, Cloneable{

    // @Override
    // protected Object clone() {
    //     try {
    //         System.out.println("克隆");
    //         return super.clone();
    //     } catch (CloneNotSupportedException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass myClass = new MyClass();
        myClass.say();
        myClass.clone();
        int[] array = new int[10];
        List<String> list = new ArrayList<>();
        list.forEach(String::length);
        Integer i1 = 199;
        Integer i2 = 199;
        System.out.println(i1 == i2);
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
    }

    public void say() {
        MyInterface.super.say();
    }


}
