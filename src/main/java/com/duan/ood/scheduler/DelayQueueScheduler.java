package com.duan.ood.scheduler;

import java.util.*;
import java.util.concurrent.*;

public class DelayQueueScheduler implements Scheduler {
    private DelayQueue<Job> queue = new DelayQueue<Job>();

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Map<String, Job> map = new ConcurrentHashMap<>();
    private Thread polling = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Job take = queue.take();
                    executorService.submit(take);
                    take.setNextExecTime();
                    if(take.getNextExecTime() > 0) {
                        queue.add(take);
                    }
                } catch (Exception e) {
                    System.out.println("polling: " + e);
                }
            }
        }
    });

    public DelayQueueScheduler() {
        this.polling.start();
    }

    @Override
    public String submitJob(Runnable runnable, int initialDelay, int interval) {
        String id = UUID.randomUUID().toString();

        Job job = new Job(runnable, initialDelay, interval);
        job.id = id;
        map.put(id, job);
        queue.add(job);
        return id;
    }

    @Override
    public List<JobRunResult> getRunResults(String jobId) {
        Job job = map.get(jobId);
        if (job == null) {
            return null;
        }
        List<JobRunResult> results = new ArrayList<>();
        results.addAll(job.results);
        return results;
    }

    @Override
    public boolean cancelJob(String jobId) {
        if (!map.containsKey(jobId)) return true;

        Job job = map.get(jobId);
        job.cancelled = true;
        return true;
    }

    class Job implements Runnable, Delayed {
        protected String id;
        // 任务待执行函数
        protected Runnable runnable;
        // 调度参数
        protected int initialDelay;
        // 调度参数
        protected int interval;

        protected volatile boolean cancelled;

        protected volatile long nextExecTime;
        // 同步队列，并发插入.
        protected List<JobRunResult> results = Collections.synchronizedList(new ArrayList<>());

        Job(Runnable runnable, int initialDelay, int interval) {
            this.id = UUID.randomUUID().toString();
            this.runnable = runnable;
            this.initialDelay = initialDelay;
            this.interval = interval;
            this.nextExecTime = System.currentTimeMillis() + initialDelay;
        }

        @Override
        public void run() {
            if (cancelled) {
                this.nextExecTime = -1;
                return;
            }
            JobRunResult runResult = new JobRunResult();
            runResult.jobId = this.id;
            runResult.success = true;
            runResult.startTime = System.currentTimeMillis();
            try {
                this.runnable.run();
                runResult.stopTime = System.currentTimeMillis();
            } catch (Exception e) {
                runResult.success = false;
                runResult.message = e.getMessage();
                runResult.stopTime = System.currentTimeMillis();
            }
            this.results.add(runResult);
            System.out.println("Job run: " + runResult.jobId + " startTime:" + runResult.startTime);
        }

        public synchronized long getNextExecTime() {
            if (!cancelled && interval > 0 && nextExecTime > 0) {
                return this.nextExecTime;
            } else {
                return -1;
            }
        }

        public synchronized void setNextExecTime() {
            if (!cancelled && interval > 0 && nextExecTime > 0) {
                this.nextExecTime = this.nextExecTime + interval;
            } else {
                this.nextExecTime = -1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.duan.ood.scheduler.Job job = (com.duan.ood.scheduler.Job) o;
            return Objects.equals(id, job.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis() - this.nextExecTime,
                    TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityQueueScheduler scheduler = new PriorityQueueScheduler();
        String jobId = scheduler.submitJob(new Runnable() {
            @Override
            public void run() {
                System.out.println("work - 1");
            }
        }, 5 * 1000, 10 * 1000);

        String jobId02 = scheduler.submitJob(new Runnable() {
            @Override
            public void run() {
                System.out.println("work - 2");
            }
        }, 3 * 1000, 10 * 1000);
        scheduler.shutdown();
    }
}


