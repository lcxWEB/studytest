package com.star.springboot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lcx on 2018/10/16.
 */
//@Component
//@WebFilter(filterName = "firstFilter", value = "/hello")
public class FirstFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init....FirstFilter");
        this.filterConfig = filterConfig;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Start.......FirstFilter doFilter");

        String noFilter = filterConfig.getInitParameter("noFilter");
        if (noFilter != null){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FirstFilter...." + ((HttpServletRequest)servletRequest).getRequestURI());
        System.out.println("FirstFilter Execute cost = " + (System.currentTimeMillis()-start));
        System.out.println("End........FirstFilter doFilter");

    }

    @Override
    public void destroy() {
        System.out.println("destroy.....FirstFilter");
    }
}
