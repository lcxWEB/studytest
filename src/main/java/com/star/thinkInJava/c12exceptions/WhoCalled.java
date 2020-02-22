package com.star.thinkInJava.c12exceptions;

import java.io.IOException;

public class WhoCalled {

    static void f() throws IOException {
        try {
            throw new IOException();
        } catch (IOException e) {
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println(element.getMethodName() + "--" + element.getClassName() + "--" + element.getLineNumber());
            }
            throw e;
        } catch (Exception e) {
            System.out.println("catch");
        }
    }

    static void g() throws IOException {
        f();
    }

    static void h() throws IOException {
        g();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (IOException e) {
            System.out.println("f--");
        }
        System.out.println("==============");
        try {
            g();
        } catch (IOException e) {
            System.out.println("g--");
        }
        System.out.println("===============");
        try {
            h();
        } catch (IOException e) {
            System.out.println("h--");
        }
        System.out.println("===============");
    }
}
