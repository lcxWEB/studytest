package com.star.spring.ioc;

import org.joda.time.DateTime;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: lcx
 * @Date: 2019/2/19 13:46
 * @Description:
 */

public class NextDayDateDisplayer {

    private DateTime dateOfNextDay;

    public DateTime getDateOfNextDay() {
        return dateOfNextDay;
    }

    public void setDateOfNextDay(DateTime dateOfNextDay) {
        this.dateOfNextDay = dateOfNextDay;
    }
}
