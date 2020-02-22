package com.star.thinkInJava.c12exceptions;

public class ExampleTest extends Exception {

    public static void main(String[] args) {
        try {
            throw new ExampleB("www");
        } catch (ExampleA exampleA) {
            System.out.println("ExampleA");
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}

class ExampleA extends Exception {

}

class ExampleB extends ExampleA {
    public ExampleB(String b) {
    }
}
