package com.zhaolearn.redisstudy;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;


public class RedisPoolStudyPipeline {
    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        Jedis jedis1 = jedisPool.getResource();
        // 开始时间
        long begin = System.currentTimeMillis();
        //使用管道缩短执行时间
        try {
            for (int j = 1; j <= 1; j++) {
                Pipeline pipeline = jedis1.pipelined();
                for (int i = (j-1)*1000; i < j*1000; i++) {
                    pipeline.set("hallo" + i, "world!!!" + i);
                }
                pipeline.syncAndReturnAll();
            }
        } catch (Exception e) {

        } finally {
            System.out.println("Pipeline运行时间为" + (System.currentTimeMillis() - begin) + "毫秒");
            if (jedis1 != null) {
                jedis1.close();
            }
        }


    }
}
