package com.star.spring.aop.demo5;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by lcx on 2018/10/13.
 */
public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("环绕前增强=========");
        Object obj = methodInvocation.proceed();
        System.out.println("环绕后增强=========");
        return obj;
    }
}
