/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.xiaoou.quartz.main;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

import java.util.concurrent.TimeUnit;

import com.xiaoou.quartz.job.MyJob;

/**
 * Created by baidu on 16/8/2.
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            // Grab the scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our MyJob class
            JobDetail job = newJob(MyJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(40)
                    .repeatForever())
                    .build();

            // Tell quartz to shedule the job using our trigger
            scheduler.scheduleJob(job, trigger);


            // and start it off
            scheduler.start();

            TimeUnit.SECONDS.sleep(80);

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
