package com.star.java.interfacedemo;

/**
 * Created by lichunxia on 2020-02-18 15:22
 */
public interface MyInterface1 {

    default void say() {
        System.out.println("hello1");
    }
}
