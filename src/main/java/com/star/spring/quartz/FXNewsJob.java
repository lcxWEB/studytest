package com.star.spring.quartz;

import com.star.spring.ioc.FXNewsProvider;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: lcx
 * @Date: 2019/3/2 17:06
 * @Description:
 */

public class FXNewsJob implements Job {

    private FXNewsProvider fxNewsProvider = new FXNewsProvider();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobExecutionContext.getJobDetail().getJobDataMap();
        getFxNewsProvider().getAndPersistNews();
    }

    public FXNewsProvider getFxNewsProvider() {
        return fxNewsProvider;
    }

    public void setFxNewsProvider(FXNewsProvider fxNewsProvider) {
        this.fxNewsProvider = fxNewsProvider;
    }
}
