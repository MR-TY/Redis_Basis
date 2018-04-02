package com.ty.redis.test;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestAPI {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.11.3", 6379);
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		System.out.println(jedis.get("k1"));
		
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());
	}
}
