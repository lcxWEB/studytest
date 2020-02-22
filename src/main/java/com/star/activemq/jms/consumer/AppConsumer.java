package com.star.activemq.jms.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lcx on 2018/10/15.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:consumer.xml");
//        applicationContext.close();
    }


}
