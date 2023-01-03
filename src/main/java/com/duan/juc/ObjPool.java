package com.duan.juc;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class ObjPool {
    // 并发访问，需要是线程安全的数据结构
    private List<Object> pool;
    private Semaphore semaphore;

    public ObjPool(int size) {
        this.semaphore = new Semaphore(size);
        this.pool = new Vector<>();
        for (int i = 0; i < size; i++) {
            this.pool.add(i);
        }
    }

    public Object exec(Function<Object, Object> func) throws InterruptedException {
        Object t = null;
        semaphore.acquire();
        try {
            t = pool.remove(pool.size() - 1);
            return func.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjPool pool = new ObjPool(10);

        for (int i = 0; i < 100; i++) {
            pool.exec(o -> {
                System.out.println(o);
                return null;
            });
        }
    }
}
