package com.star.thinkInJava.c3operators;

import java.util.Random;

class TestOP {

    public TestOP() {}

}


public class Operators {

    public static void print() {
        System.out.println("print");
    }

//    i = 11;
    private int i = 10;

    public static void main(String[] args) {
        System.out.println(11 / 3.0);
        System.out.println(11.0 / 3.0);
        System.out.println(11.0 / 3.0 + 1);
        System.out.println(11.0 / 3.0 + 1.0);
        System.out.println(11 / 3 + 1.0);
        System.out.println(11 % 3);
        System.out.println(11.2 % 3 + 1.0);


        Random random = new Random(47);
        System.out.println(random.nextInt(100));


        System.out.println("test " + Boolean.TRUE);
    }
}
