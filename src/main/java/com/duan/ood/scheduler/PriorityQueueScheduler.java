package com.duan.ood.scheduler;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 这个方案基于优先级队列。插入的复杂度是删除的复杂度是 O（lgn）
 *
 * 核心组件
 * 1、任务队列 - 优先级队列
 * 2、polling 线程 - 基于锁通知进行唤醒
 * 3、任务执行线程 - 标准的线程池
 *
 * 其他
 * 1、并发数据结构
 * 2、对象的可并发修改的参数
 *
 * 问题是什么？
 * 1、复杂度
 *
 */
public class PriorityQueueScheduler implements Scheduler {
    private PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<>(11, (o1, o2) -> {
        return (int) (o1.nextExecTime - o2.nextExecTime);
    });
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Map<String, Job> map = new ConcurrentHashMap<>();
    private Object mutex = new Object();
    private Thread polling = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (mutex) {
                while (true) {
                    try {
                        Job job = queue.peek();
                        if (job == null) {
                            mutex.wait(20000);
                            continue;
                        }
                        long nextExecTime = job.getNextExecTime();

                        if (System.currentTimeMillis() >= nextExecTime) {
                            Job jobTodo = queue.poll();
                            if(jobTodo == null) {
                                continue;
                            }
                            executorService.submit(jobTodo);
                            job.setNextExecTime();
                            if (job.getNextExecTime() > 0) {
                                queue.add(jobTodo);
                                mutex.notify();
                            }
                        } else {
                            mutex.wait(Math.max(100, nextExecTime - System.currentTimeMillis()));
                        }
                    } catch (Exception e) {
                        System.out.println("polling: " + e);
                    }
                }
            }
        }
    });

    public PriorityQueueScheduler() {
        this.polling.start();
    }

    @Override
    public String submitJob(Runnable runnable, int initialDelay, int interval) {
        String id = UUID.randomUUID().toString();

        Job job = new Job(runnable, initialDelay, interval);
        job.id = id;
        map.put(id, job);
        queue.add(job);
        synchronized (mutex) {
            mutex.notify();
        }
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

    public void shutdown() {

    }
}

class Job implements Runnable {
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
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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