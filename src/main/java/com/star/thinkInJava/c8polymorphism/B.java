package com.star.thinkInJava.c8polymorphism;

public class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    @Override
    public String show(A obj){
        return ("B and A");
    } 
}