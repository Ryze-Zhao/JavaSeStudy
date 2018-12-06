package com.zhaolearn.redisstudy;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisPoolStudyRDBAOF {
    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6380);
        Jedis jedis1 = jedisPool.getResource();
        Jedis jedis2 = jedisPool.getResource();
        Runnable oneThread=()->{
            try {
                for (int i = 1; i <= 2500000; i++) {
                    jedis1.set("hallo" + i, "world!!!" + i);
                }
          /*  for (int i = 1; i <= 10; i++) {
                System.out.println(jedis.get("hallo" + i));
            }*/
            } catch (Exception e) {

            } finally {
                if (jedis1 != null) {
                    jedis1.close();
                }
            }
        };
        Runnable twoThread=()->{
            try {
                for (int i = 2500001; i <= 5000000; i++) {
                    jedis2.set("hallo" + i, "world!!!" + i);
                }
          /*  for (int i = 1; i <= 10; i++) {
                System.out.println(jedis.get("hallo" + i));
            }*/
            } catch (Exception e) {

            } finally {
                if (jedis2 != null) {
                    jedis2.close();
                }
            }
        };

        oneThread.run();
        twoThread.run();

    }
}
