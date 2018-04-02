package com.ty.redis.test;

import redis.clients.jedis.Jedis;

public class TestMS {
	public static void main(String[] args) {
		Jedis jedis_M = new Jedis("192.168.11.3", 6379,100000);
		Jedis jedis_S = new Jedis("192.168.11.3", 6380,100000);
		//从机配置，主机不变
		jedis_S.slaveof("192.168.11.3", 6379);
		//主机写，从机读
		jedis_M.set("hh", "你是猪吗");
		String val = jedis_S.get("hh");
		System.out.println(val);
	}
}
