package com.pbc.demo.myQuartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    private String message;
    private Float FloatJobValue;
    private double DoubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    public double getDoubleTriggerValue() {
        return DoubleTriggerValue;
    }

    public void setDoubleTriggerValue(double doubleTriggerValue) {
        DoubleTriggerValue = doubleTriggerValue;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + sf.format(date));
        //System.out.println("Hello Word!");
        JobKey key = context.getJobDetail().getKey();
        System.out.println("my job name and group are L" + key.getName() + ":" + key.getGroup());

        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println("my trigger name and group are L" + triggerKey.getName() + ":" + triggerKey.getGroup());

        // TODO: 2018/1/16 取参方式二会丢掉名字重复的key值 第二个会覆盖掉第一个key值
       /* JobDataMap dataMap = context.getMergedJobDataMap();
        String jobmsg = dataMap.getString("message");
        Float jobFloatValue = dataMap.getFloatValue("FloatJobValue");
        String triggerMmsg = dataMap.getString("message");
        Double triggerDoubleValue = dataMap.getDouble("DoubleTriggerValue");*/

        // TODO: 2018/1/16 取参方式一 不会丢失名字相同的参数值
         /*  JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        JobDataMap tdataMap = context.getTrigger().getJobDataMap();
        String jobmsg = dataMap.getString("message");
        Float jobFloatValue = dataMap.getFloatValue("FloatJobValue");
        String triggerMmsg = tdataMap.getString("message");
        Double triggerDoubleValue = tdataMap.getDouble("DoubleTriggerValue");*/

        System.out.println("jobmsg:" + message);
        System.out.println("jobFloatValue:" + FloatJobValue);
        //System.out.println("triggerMmsg:" + triggerMmsg);
        System.out.println("triggerDoubleValue:" + DoubleTriggerValue);


    }
}