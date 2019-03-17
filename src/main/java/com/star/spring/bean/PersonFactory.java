package com.star.spring.bean;

/**
 * Created by lcx on 2018/10/12.
 */
public class PersonFactory {

    public static Person getPerson(){
        return new Person();
    }
}
