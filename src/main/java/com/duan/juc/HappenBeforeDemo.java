package com.duan.juc;

public class HappenBeforeDemo {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });
        t.start();
        t.join();

        System.out.println(counter);
    }
}
