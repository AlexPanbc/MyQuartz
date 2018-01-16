package com.pbc.demo.myQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * Created by Alex on 2018/1/16.
 */
public class MyCornTrigger {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(CornJob.class).withIdentity("CornTriggerJob").build();
        CronTrigger trigger = (CronTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("MyCornTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
