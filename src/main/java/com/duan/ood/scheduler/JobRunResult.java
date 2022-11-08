package com.duan.ood.scheduler;

public class JobRunResult {
    protected String jobId;

    /**
     * whether the job execution succeeds
     * If there's any Throwable thrown from the runnable submitted, consider it as fail
     * Otherwise consider it as success.
     */
    protected boolean success;

    protected String message;

    /**
     * Job start time in epoch seconds
     */
    protected long startTime;

    /**
     * job end time in epoch seconds
     */
    protected long stopTime;

    @Override
    public String toString() {
        return "JobRunResult{" +
                "jobId='" + jobId + '\'' +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                '}';
    }
}
