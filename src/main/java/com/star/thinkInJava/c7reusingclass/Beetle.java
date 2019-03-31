package com.star.thinkInJava.c7reusingclass;


import static com.star.thinkInJava.c11holding.SetOperations.print;

class Insect {
    private static int x1 = printInit("static Insect.x1 initialized");
    protected int j;
    private int i = 9;

    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        print(s);
        return 47;
    }
}


public class Beetle extends Insect {
    private static int x2 = printInit("static Beetle.x2 initialized");
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    public static void main(String[] args) {
        print("Beetle constructor");
//        Beetle b = new Beetle();
//        Beetle b1 = new Beetle();
    }
}
