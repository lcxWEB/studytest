package com.star.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lcx
 * @Date: 2019/2/18 19:48
 * @Description:
 */

public class ComScanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com-scan.xml");
        FXNewsProvider newsProvider = (FXNewsProvider) context.getBean("djNewsProvider");
        System.out.println("从ApplicationContext中获取的BEAN：" + newsProvider);
        System.out.println(newsProvider.getNewsListener());
        System.out.println(newsProvider.getNewsPersister());
        // System.out.println(newsProvider.getValueSet());
        // newsProvider.getAndPersistNews();
    }
}
