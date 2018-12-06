package com.zhaolearn.redisstudy;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 */
public class RedisStudy {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 1; i <= 10; i++) {
            jedis.set("hallo"+i, "world!!!"+i);
        }
        for (int i = 1; i <= 10; i++) {
           System.out.println(jedis.get("hallo"+i));
        }
    }
}
