package com.star.spring.aspectj.demo2;

import org.aspectj.lang.JoinPoint;

/**
 * Created by lcx on 2018/10/14.
 */
public class MyAspectXml {

//    前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("XML方式的前置通知----========" + joinPoint);
    }
}
