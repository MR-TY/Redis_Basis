package com.ty.redis.test;

import redis.clients.jedis.Jedis;

public class TestPing {
	public static void main(String[] args) {
		System.out.println("开始");
		Jedis jedis = new Jedis("192.168.11.3",6379,100000);
		
		System.out.println(jedis);
		System.out.println(jedis.ping());
		System.out.println("连接成功");
	}
}
