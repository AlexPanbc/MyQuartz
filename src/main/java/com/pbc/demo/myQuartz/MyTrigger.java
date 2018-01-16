package com.pbc.demo.myQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 2018/1/16.
 */
public class MyTrigger {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(TriggerJob.class).withIdentity("mytriggerJob").build();

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("mytrigger里的当前时间：" + sf.format(date));

     /*   // TODO: 2018/1/16 三秒执行一次 6秒结束执行 共执行两次
        date.setTime(date.getTime() + 3000);
        Date endTime = new Date();
        endTime.setTime(endTime.getTime() + 6000);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("mytriggert")
                .startAt(date)
                .endAt(endTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())//repeatForever无限执行
                .build();*/
        date.setTime(date.getTime() + 4000);
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("mytriggert")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(3))
                .build();

        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
