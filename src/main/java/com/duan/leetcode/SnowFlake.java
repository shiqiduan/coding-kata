package com.duan.leetcode;

public class SnowFlake {
    private final static long startTime = System.currentTimeMillis();

    // 32 台机器
    private final static Long workerIdBits = 5L;
    private final static Long dcIdBits = 5L;
    // 4096
    private final static long seqBits = 12L;

    private final static long maxWorkerId = (1 << workerIdBits) - 1;
    private final static long maxDcId = (1 << dcIdBits) - 1;
    private final static long maxSeq = (1 << seqBits) - 1;

    private final static long workerIdShift = seqBits;
    private final static long dcIdShift = workerIdBits + seqBits;
    private final static long timestampShift = seqBits + workerIdBits + dcIdBits;

    private long dcId;
    private long workerId;
    private long seq = 0L;
    private long lastTimeStamp = -1L;

    public SnowFlake(long workerId, long dcId) {
        this.dcId = dcId;
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timeStamp = System.currentTimeMillis();
        if(timeStamp < lastTimeStamp) {
            throw new RuntimeException();
        }
        if(timeStamp == lastTimeStamp) {
            seq = (seq + 1) & maxSeq;
            if(seq == 0L) {
                timeStamp = nextMillis();
            }
        } else {
            seq = 0L;
        }
        lastTimeStamp = timeStamp;
        return (timeStamp) << timestampShift
                | dcId << dcIdShift
                | workerId << workerIdShift
                | seq;
    }

    private long nextMillis() {
        long timeStamp = System.currentTimeMillis();
        while (timeStamp < lastTimeStamp) {
            timeStamp = System.currentTimeMillis();
        }
        return timeStamp;
    }

    public static void main(String[] args) {
        System.out.println(SnowFlake.maxWorkerId);
        System.out.println(SnowFlake.maxDcId);
        System.out.println(SnowFlake.maxSeq);

        SnowFlake sf = new SnowFlake(12, 25);
        System.out.println(Long.toBinaryString(sf.nextId()));
        System.out.println(Long.toBinaryString(sf.nextId()));
        System.out.println(Long.toBinaryString(sf.nextId()));

        System.out.println("a");
    }
}
