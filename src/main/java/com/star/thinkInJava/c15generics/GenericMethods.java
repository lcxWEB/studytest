package com.star.thinkInJava.c15generics;//: generics/GenericMethods.java

public class GenericMethods {

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1.0);
        gm.f(1, 2.0, 4);
        gm.f(1.0, 'v', 'b');
        gm.f(1.0F, 'v', 'b');
        gm.f('c', 'v', 'b');
        gm.f(gm, gm, gm);
    }

    public <T, X, Y> void f(T x, X x1, Y y) {
        System.out.println(x.getClass().getName() + " " + x1.getClass().getName() + " " + y.getClass().getName());
    }
} /* Output:
java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
GenericMethods
*///:~
