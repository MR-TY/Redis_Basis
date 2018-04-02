package com.ty.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.11.3", 6379,100000);
		//---------开启事务----------
		Transaction transaction = jedis.multi();
		transaction.set("k3", "v3");
		transaction.set("k4", "v4");
		transaction.set("k5", "v5");
		transaction.set("k6", "v6");
		transaction.set("k7", "v7");
		transaction.set("k8", "v8");
		//--------事务提交----------
		transaction.exec();
	}
}
