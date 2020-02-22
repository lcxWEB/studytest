package com.star.concurrent;

/**
 * @Author: lcx
 * @Date: 2019/2/25 14:38
 * @Description:
 */

public class LogWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + "：call doSomething");
        super.doSomething();
    }

    public static void main(String[] args) {
        new LogWidget().doSomething();
    }
}
