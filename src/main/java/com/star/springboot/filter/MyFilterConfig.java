package com.star.springboot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.HashMap;

/**
 * Created by lcx on 2018/10/16.
 */
@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){
        HashMap initParams = new HashMap();
        initParams.put("noFilter","getUUAgentList2");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FirstFilter());
        registrationBean.addUrlPatterns("/r*");
        registrationBean.setName("filterTest");
        registrationBean.setInitParameters(initParams);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean registrationBean2(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SecondFilter());
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        registrationBean.addUrlPatterns("/h");
        registrationBean.setName("filterTest2");
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
