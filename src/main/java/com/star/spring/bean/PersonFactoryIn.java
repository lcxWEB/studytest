package com.star.spring.bean;

/**
 * Created by lcx on 2018/10/12.
 */
public class PersonFactoryIn {

    public Person createPerson(){
        System.out.println("--实例工厂的方式初始化bean--");
        return new Person();
    }

}

