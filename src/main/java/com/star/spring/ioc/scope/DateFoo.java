package com.star.spring.ioc.scope;

import java.util.Date;

/**
 * @Author: lcx
 * @Date: 2019/2/20 20:20
 * @Description:
 */

public class DateFoo {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void close() {
        System.out.println("bean destroyed");
    }
}
