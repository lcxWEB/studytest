package com.star.spring.ioc.scope;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Author: lcx
 * @Date: 2019/2/19 17:01
 * @Description:
 */

public class FXNewsProviderMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("before executing method[" + method.getName() +
                "] on Object[" + target.getClass().getName() + "].");
        System.out.println("sorry,We will do nothing this time.");
        System.out.println("end of executing method[" + method.getName() +
                "] on Object[" + target.getClass().getName() + "].");
        return null;
    }
}
