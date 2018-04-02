package com.ty.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class TestPool {
	public static void main(String[] args) {
		JedisPool jedisPool1 = TestJedisPool.getJedisPool();
//		JedisPool jedisPool2 = TestJedisPool.getJedisPool();
//		System.out.println(jedisPool1 == jedisPool2);//输出为true证明单例模式成功
		Jedis jedis = null;
		try{
			jedis = jedisPool1.getResource();
			jedis.set("a", "aaaaaaaa");
			System.out.println(jedis.get("a"));
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			TestJedisPool.release(jedisPool1, jedis);
		}
	}
}
