/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.xiaoou.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by baidu on 16/8/2.
 */
public class MyJob implements org.quartz.Job {
    public MyJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello World! MyJob is executing.");
    }
}
