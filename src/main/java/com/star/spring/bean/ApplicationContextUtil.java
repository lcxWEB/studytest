package com.star.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lcx on 2018/10/11.
 */
public final class ApplicationContextUtil {

    private static ApplicationContext applicationContext = null;

    private ApplicationContextUtil(){

    }

    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


}
