package com.star.spring.ioc;

import org.joda.time.DateTime;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: lcx
 * @Date: 2019/2/19 13:41
 * @Description:
 */

public class NextDayDateFactoryBean implements FactoryBean {

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Object getObject() throws Exception {
        return new DateTime().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return DateTime.class;
    }
}
