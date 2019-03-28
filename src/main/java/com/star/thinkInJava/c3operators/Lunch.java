package com.star.thinkInJava.c3operators;


class Soup1 {
    private Soup1() {
    }
    private static int i;

    // (1) Allow creation via static method:
    public static Soup1 makeSoup() {
        i++;
        System.out.println(i);
        return new Soup1();
    }
}

class Soup2 {
    // (2) Create a static object and return a reference
// upon request.(The "Singleton" pattern):
    private static Soup2 ps1 = new Soup2();

    private Soup2() {
    }

    public static Soup2 access() {
        return ps1;
    }

    public void f() {
        System.out.println("f()");
    }
}

// Only one public class allowed per file:
public class Lunch {
    void testPrivate() {
// Can’t do this! Private constructor:
//! Soup1 soup = new Soup1();
    }

    static void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

    public static void main(String[] args) {
        testStatic();
        testStatic();
        testStatic();
    }
}

