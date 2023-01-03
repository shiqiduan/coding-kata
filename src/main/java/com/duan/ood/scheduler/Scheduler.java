package com.duan.ood.scheduler;

import java.util.List;

/**
 * Please implement a (in-memory) job scheduler
 * This scheduler should provide following methods: submitJob, getRunResults, cancelJob
 * Job submitted to the scheduler should be invoked at correct time
 * This scheduler should support one-time jobs and repeatable jobs
 * The implementation should be thread-safe
 * The implementation should show good OO design skills
 */
public interface Scheduler {

    /**
     * Submit a job (Runnable) to Scheduler
     * This job will be first invoked after {@code initialDelay} seconds from submission time.
     * If {@code interval} is larger than 0, the job will be repeatedly invoked every {@code interval} seconds
     * @param runnable The job to run
     * @param initialDelay initial wait time before first invocation (in seconds)
     * @param interval interval between repeat jobs
     * @return jobId
     */
    String submitJob(Runnable runnable, int initialDelay, int interval);

    /**
     * Return job run result history for a given job, from the first invocation to latest invocation
     * @param jobId The Id of job whose run result history is returned
     * @return Run result history of this job, sorted by startTime from small to large
     */
    List<JobRunResult> getRunResults(String jobId);

    /**
     * Cancel one scheduled job
     * For repeated jobs, cancel all scheduled invocation
     * If one job is running with this method is called, cancel it after this invocation finishes.
     * Do nothing if the job doesn't exist, or it's a finished non-repeated job
     * @param jobId the Id of the job to cancel
     * @return success or not
     */
    boolean cancelJob(String jobId);
}
