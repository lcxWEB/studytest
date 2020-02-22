//: generics/coffee/Coffee.java
package com.star.thinkInJava.c15generics;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~
