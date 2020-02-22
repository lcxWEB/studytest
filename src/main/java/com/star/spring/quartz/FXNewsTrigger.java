package com.star.spring.quartz;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: lcx
 * @Date: 2019/3/2 17:18
 * @Description:
 */

public class FXNewsTrigger {

    public static void main(String[] args) throws ParseException, SchedulerException {

        Trigger cronTrigger = new CronTriggerImpl("cronTriggerName", Scheduler.DEFAULT_GROUP, "0 0/1 * * * ?");

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        JobDetail jobDetail = new JobDetailImpl("jobName", Scheduler.DEFAULT_GROUP, FXNewsJob.class);
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }

    Trigger simpleTrigger = new SimpleTriggerImpl("triggerName", Scheduler.DEFAULT_GROUP, new Date(),
            null, SimpleTrigger.REPEAT_INDEFINITELY, 60000);


}
