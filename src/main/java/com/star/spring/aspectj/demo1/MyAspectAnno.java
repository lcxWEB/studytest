package com.star.spring.aspectj.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

/**
 * Created by lcx on 2018/10/14.
 */

@Aspect
public class MyAspectAnno {

//    @Before(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.save(..))")
//    在方法中传入JoinPoint参数，可以获得切入点信息
    @Before(value = "myPointCut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知====================" + joinPoint);
    }


//    @AfterReturning(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.update(..))", returning = "result")
    @AfterReturning(value = "myPointCut1()", returning = "result")
    public void afterReturning(Object result){
        System.out.println("~~~~后置通知====================" + result);
    }


    @Around(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.delete(..))")
//    ProceedingJoinPoint--调用目标方法执行，如果不调用ProceedingJoinPoint.proceed那么目标方法就不执行
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知====");
        Object object = joinPoint.proceed();
        System.out.println("-----环绕后通知====");
        return object;
    }

    @AfterThrowing(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.findOne(..))", throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知====" + e.getMessage());
    }

    @After(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.findAll(..))")
    public void after(){
        System.out.println("最终通知====");
    }


    @Pointcut(value = "execution(* com.star.spring.aspectj.demo1.ProductDao.save(..))")
    public void myPointCut1(){

    }

}
