package com.star.thinkInJava.c9interfaces;

class ClassA extends AbstractClassA implements InterfaceA {
    @Override
    public void foo() {
        InterfaceA.super.foo();
    }
}