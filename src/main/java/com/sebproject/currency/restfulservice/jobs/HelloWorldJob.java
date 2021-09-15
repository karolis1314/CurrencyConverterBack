package com.sebproject.currency.restfulservice.jobs;

import com.sebproject.currency.restfulservice.currencycontroller.CurrencyController;
import com.sebproject.currency.restfulservice.info.TimerInfo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJob implements Job{
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);
    @Override
    public void execute(JobExecutionContext context){
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        LOG.info("Remaining fire count is '{}'", info.getRemainingFireCount());

        CurrencyController currencyController = new CurrencyController();
        currencyController.getCurrent();
    }
}