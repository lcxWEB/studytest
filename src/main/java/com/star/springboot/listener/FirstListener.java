package com.star.springboot.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by lcx on 2018/10/17.
 */
//@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("app_name", "springboottest");
        System.out.println("context init ... ...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String appName = (String) servletContextEvent.getServletContext().getAttribute("app_name");
        System.out.println("context destroy ... ..." + appName);
    }
}
