package com.star.thinkInJava.c7reusingclass;

class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private static int k;


    private final int i; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference

    {
        i = 0;
        System.out.println("i=0000");
    }

    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
//        j = x; // 赋值之后无法再修改
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
//        System.out.println(BlankFinal.k);
        BlankFinal bf = new BlankFinal();
        System.out.println(bf.j);
        System.out.println(bf.i);
        System.out.println(bf.p);
        new BlankFinal(47);
    }


    static {
        k = 10;
        System.out.println("k====");
    }
}