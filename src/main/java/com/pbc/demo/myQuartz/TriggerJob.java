package com.pbc.demo.myQuartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 2018/1/16.
 */
public class TriggerJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("TriggerJob当前时间：" + sf.format(date));
        Trigger current = context.getTrigger();
        System.out.println("start time is ：" + sf.format(current.getStartTime()));
        System.out.println("end time is ：" + sf.format(current.getEndTime()));
        JobKey key = current.getJobKey();

        System.out.println("job key info jobname ：" + key.getName() + "jobgroup:" + key.getGroup());

    }
}
