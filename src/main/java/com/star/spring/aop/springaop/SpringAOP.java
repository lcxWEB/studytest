package com.star.spring.aop.springaop;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @Author: lcx
 * @Date: 2019/2/23 10:28
 * @Description:
 */

public class SpringAOP {

    public static void main(String[] args) {
        MockTask task = new MockTask();
        // ProxyFactory weaver = new ProxyFactory(task);
        ProxyFactory weaver = new ProxyFactory(new Executable());
        weaver.setProxyTargetClass(false);
        // weaver.setInterfaces(new Class[]{ITask.class});
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        System.out.println(advisor);
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        // ITask proxyObject = (ITask) weaver.getProxy();
        Advised proxyObject = (Advised) weaver.getProxy();
        System.out.println(proxyObject.getAdvisors());
        System.out.println(proxyObject.removeAdvisor(advisor));
        // Executable proxyObject = (Executable) weaver.getProxy();
        // proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }

}
