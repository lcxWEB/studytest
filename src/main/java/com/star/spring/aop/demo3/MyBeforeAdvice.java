package com.star.spring.aop.demo3;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Created by lcx on 2018/10/13.
 */

public class MyBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("前置增强==#######===");
    }
}
