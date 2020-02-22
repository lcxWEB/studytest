package com.star.spring.aop.springaop.aspect;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Author: lcx
 * @Date: 2019/2/24 15:06
 * @Description:
 */

public class AspectAOPTest {

    public static void test() {

    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }

}
