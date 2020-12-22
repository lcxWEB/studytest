package com.star.jvm.bytecode;

/**
 * @Author: lcx
 * @Date: 2019/3/9 19:17
 * @Description:
 */

public class StaticResolution {

    static final long l = 99L;
    static int i = 100;

    int m = 88;

    public static int sayHello() {
        System.out.println("hello world");
        return 0;
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();

        // InnerStaticClass.print();

        StaticResolution staticResolution = new StaticResolution();
        InnerNotStaticClass innerNotStaticClass = staticResolution.new InnerNotStaticClass();
        innerNotStaticClass.print();
        System.out.println(staticResolution.m);
    }

    static class InnerStaticClass {
        static int print() {
            System.out.println(i);
            return 0;
        }
    }

    class InnerNotStaticClass {
        int n = 10;
        int print() {
            System.out.println(i);
            System.out.println(m);
            this.n = 1010;
            StaticResolution.this.m = 170;
            System.out.println(m);
            System.out.println(n);
            return 0;
        }
    }

}
