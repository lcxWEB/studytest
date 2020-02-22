package com.star.spring.aop.springaop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

/**
 * @Author: lcx
 * @Date: 2019/2/23 10:26
 * @Description:
 */

public class PerformanceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return invocation.proceed();
        } finally {
            watch.stop();
            System.out.println(watch.toString());
        }

    }
}
