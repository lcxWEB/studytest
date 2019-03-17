package com.star.design.pattern.creational.prototype.abstractprototype;

/**
 * @Author: lcx
 * @Date: 2019/1/15 19:09
 * @Description:
 */

public abstract class A implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
