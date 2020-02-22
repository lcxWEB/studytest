package com.star.design.pattern.creational.singleton;

/**
 * @Author: lcx
 * @Date: 2018/12/19 10:28
 * @Description:
 */

public class T implements Runnable {

    @Override
    public void run() {
        // LazySingleton instance = LazySingleton.getInstance();
        // LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        // StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        // ContainerSingleton.putInstance("object", new Object());
        // Object instance = ContainerSingleton.getInstance("object");
        ThreadLocalInstance instance = ThreadLocalInstance.getIntance();
        System.out.println(Thread.currentThread().getName() + " == " + instance);
    }
}
