package com.star.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * @Author: lcx
 * @Date: 2019/2/24 14:58
 * @Description:
 */

@Aspect
public class PerformanceTraceAspect {

    @Pointcut("execution(public void *.method1()) || execution(public void *.method2()) || this(Foo) || @annotation(com.star.spring.aop.springaop.aspect.MyAnnotation) || args(aa)")
    public void pointcutName(String aa) {}

    @Around("pointcutName(aa) || com.star.spring.aspectj.demo1.MyAspectAnno.myPointCut1()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint, String aa) throws Throwable {
        StopWatch watch = new StopWatch();
        try {
            watch.start();
            return joinPoint.proceed();
        } finally {
            watch.stop();
            System.out.println(watch.toString());
        }

    }

}
