package com.star.jvm.polymorphic;

/**
 * @Author: lcx
 * @Date: 2019/3/9 19:30
 * @Description:
 */

public class DynamicDispatch {

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hello, gentleman!");
        }
    }

    static class Women extends Human {
        @Override
        protected void sayHello() {
            System.out.println("hello, lady!");
        }
    }


    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();
        man.sayHello();
        women.sayHello();
        man = new Women();
        man.sayHello();
    }

}
