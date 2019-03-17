package com.star.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @Author: lcx
 * @Date: 2019/1/14 15:32
 * @Description:
 */

public class HungrySingleton implements Serializable, Cloneable {

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private HungrySingleton(){
        if (hungrySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射調用");
        }
    }

    private Object readResolve() {
        return hungrySingleton;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();
        return getInstance();
    }
}
