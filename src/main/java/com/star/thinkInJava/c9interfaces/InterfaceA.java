package com.star.thinkInJava.c9interfaces;

interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }

    default void bar() {
        System.out.println("InterfaceA bar");
    }

    default void foo1() {
        printHelloWorld();
    }

    static void printHelloWorld() {
        System.out.println("hello, world");
    }

}