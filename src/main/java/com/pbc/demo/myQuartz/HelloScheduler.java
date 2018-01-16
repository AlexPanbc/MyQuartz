package com.pbc.demo.myQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Alex on 2018/1/16.
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob").
                usingJobData("message", "hello myJob1").
                usingJobData("FloatJobValue", 3.14F).build();
// TODO: 2018/1/16 打印当前的类和组
       /* System.out.println("jobDetail's Name:"+jobDetail.getKey().getName());
        System.out.println("jobDetail's getGroup:"+jobDetail.getKey().getGroup());
        System.out.println("jobDetail's getClass:"+jobDetail.getJobClass().getName());*/

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
                .usingJobData("DoubleTriggerValue",2.0D)
                .usingJobData("message","hello myTrigger1")
                .startNow().
                        withSchedule(SimpleScheduleBuilder.simpleSchedule().
                                withIntervalInSeconds(2).
                                repeatForever()).build();
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("hello scheduler 时间：" + sf.format(date));
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
