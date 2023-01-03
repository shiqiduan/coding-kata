package com.duan.dlm;

import redis.clients.jedis.JedisPooled;

public class JRedisDemo {
    JedisPooled jedis = new JedisPooled("localhost", 6379);

    public void test() {
        System.out.println(jedis.get("aaa"));
        jedis.set("aaa", System.nanoTime() + "");
        System.out.println(jedis.get("aaa"));
    }

    public static void main(String[] args) {
        JRedisDemo demo = new JRedisDemo();
        demo.test();
    }
}
