package com.star.springboot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lcx on 2018/10/16.
 */
//@Component
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init.....SecondFilter");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Start.......SecondFilter doFilter");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("SecondFilter...." + ((HttpServletRequest)servletRequest).getRequestURI());
        System.out.println("SecondFilter Execute cost = " + (System.currentTimeMillis()-start));
        System.out.println("End........SecondFilter doFilter");

    }

    @Override
    public void destroy() {
        System.out.println("destroy.....SecondFilter");
    }
}
