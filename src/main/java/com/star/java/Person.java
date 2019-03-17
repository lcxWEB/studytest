package com.star.java;

/**
 * @Author: lcx
 * @Date: 2019/2/14 16:43
 * @Description:
 */

public abstract class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDesc();

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
