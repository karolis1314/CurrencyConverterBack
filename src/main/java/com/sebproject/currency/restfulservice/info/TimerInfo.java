package com.sebproject.currency.restfulservice.info;
import java.io.Serializable;


public class TimerInfo implements Serializable {
    private int totalFireCount;
    private int remainingFireCount;
    private boolean runForever;
    private int repeatIntervalMs;
    private int initialOffsetMs;
    private String callbackData;

    public int getTotalFireCount() {
        return totalFireCount;
    }

    public void setTotalFireCount(int totalFireCount) {
        this.totalFireCount = totalFireCount;
    }

    public int getRemainingFireCount() {
        return remainingFireCount;
    }

    public void setRemainingFireCount(int remainingFireCount) {
        this.remainingFireCount = remainingFireCount;
    }

    public boolean isRunForever() {
        return runForever;
    }

    public void setRunForever(boolean runForever) {
        this.runForever = runForever;
    }

    public int getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    public void setRepeatIntervalMs(int repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
    }

    public long getInitialOffsetMs() {
        return initialOffsetMs;
    }

    public void setInitialOffsetMs(int initialOffsetMs) {
        this.initialOffsetMs = initialOffsetMs;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }
}