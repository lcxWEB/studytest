package com.star.thinkInJava.c5initandclean;

import org.apache.commons.logging.Log;

import java.util.logging.Logger;

public class B {

    // java.lang.StackOverflowError
   // public  B t1 = new B();
//    public static B t2 = new B();

    private String value = Logger.GLOBAL_LOGGER_NAME;

    public B() {
        System.out.println("父类构造函数");
    }

    static {
        System.out.println("父类静态块");
    }

    {
        System.out.println(value);
        System.out.println("父类构造块");
    }

}
