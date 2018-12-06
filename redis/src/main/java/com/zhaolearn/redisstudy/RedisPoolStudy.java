package com.zhaolearn.redisstudy;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisPoolStudy {
    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        Jedis jedis1 = null;
        // 开始时间
        long begin = System.currentTimeMillis();
        try {
            jedis1 = jedisPool.getResource();
            for (int i = 1; i <= 1000; i++) {
                jedis1.set("hallo" + i, "world!!!" + i);
            }
          /*  for (int i = 1; i <= 10; i++) {
                System.out.println(jedis.get("hallo" + i));
            }*/
        } catch (Exception e) {
        } finally {
            System.out.println("Pipeline运行时间为" + (System.currentTimeMillis() - begin) + "毫秒");
            if (jedis1 != null) {
                jedis1.close();
            }
        }


    }
}
