package com.sebproject.currency.restfulservice.playground;

import com.sebproject.currency.restfulservice.info.TimerInfo;
import com.sebproject.currency.restfulservice.jobs.RunFetchAllCurrencyTodayJob;
import com.sebproject.currency.restfulservice.timeservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final SchedulerService scheduler;

    @Autowired
    public JobService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runFetchAllToday() {
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(7);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRepeatIntervalMs(1);
        info.setInitialOffsetMs(1);
        info.setCallbackData("My callback data");

        scheduler.schedule(RunFetchAllCurrencyTodayJob.class, info);
    }

    public Boolean deleteTimer(final String timerId) {
        return scheduler.deleteTimer(timerId);
    }

    public List<TimerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimers();
    }

    public TimerInfo getRunningTimer(final String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}