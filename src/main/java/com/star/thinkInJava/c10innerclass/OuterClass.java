package com.star.thinkInJava.c10innerclass;

public class OuterClass {

    public void display( String name, String age) {
        class InnerClass {
            void display() {
                System.out.println(name);
            }
        }

        new InnerClass().display();
    }

    public static void main(String[] args) {

        new OuterClass().display("555", "222");
    }
}