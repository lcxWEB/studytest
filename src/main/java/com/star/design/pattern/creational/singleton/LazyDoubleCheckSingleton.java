package com.star.design.pattern.creational.singleton;

/**
 * @Author: lcx
 * @Date: 2018/12/19 10:50
 * @Description:
 */

public class LazyDoubleCheckSingleton {

    //共享内存可见
    private volatile static LazyDoubleCheckSingleton lazySingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                //    1. 分配内存给这个对象
                //    2. 初始化对象
                //    3. 设置lazySingleton指向这个对象
                }
            }
        }
        return lazySingleton;
    }

}
