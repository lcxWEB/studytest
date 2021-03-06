package com.star.design.pattern.creational.singleton;

/**
 * @Author: lcx
 * @Date: 2019/1/14 17:02
 * @Description:
 */

public enum EnumInstance {

    INSTANCE {
        protected void printTest() {
            System.out.println("Geely Print Test");
        }
    };

    protected abstract void printTest();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
