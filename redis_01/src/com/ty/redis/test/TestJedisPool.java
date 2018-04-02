package com.ty.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 单例模式：懒汉模式，没有直接拿出对象，而是通过判断是否存在对象，在决定是否拿出对象
 * 1.声明一个静态应用变量，这个变量就是你下面所要获取的
 * 2.声明一个无参构造函数，因为有了这个无参构造函数就不能在new对象
 * 3.获取函数，先判断是否存在，在进行同步锁上，在进行判断是否存在，不存在就new 对象出来，在返回
* Copyright: Copyright (c) 2018 LanRu-Caifu
* 
* @ClassName: TestJedisPool.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: water
* @date: 2018年4月2日 下午8:44:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月2日       water           v1.0.0               修改原因
 */
public class TestJedisPool {
	private static volatile JedisPool jedisPool = null;
	
	public TestJedisPool() {
	}
/**
 * 获取对象
* @Function: TestJedisPool.java
* @Description: 该函数的功能描述
*
* @param:描述1描述
* @return：返回结果描述
* @throws：异常描述
*
* @version: v1.0.0
* @author: water
* @date: 2018年4月2日 下午8:47:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月2日       water           v1.0.0               修改原因
 */
	public static JedisPool getJedisPool() {
		if (null == jedisPool) {
			synchronized (TestJedisPool.class) {
				if (jedisPool == null) {
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxActive(1000);
					config.setMaxIdle(32);
					config.setMaxWait(1000 * 100);
					config.setTestOnBorrow(true);
					jedisPool = new JedisPool(config, "192.168.11.3", 6379);
				}
			}
		}
		return jedisPool;
	}
	/**
	 * 用完之后放回池子，释放对象
	* @Function: TestJedisPool.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: water
	* @date: 2018年4月2日 下午8:47:40 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年4月2日       water           v1.0.0               修改原因
	 */
	public static void release(JedisPool jedisPool, Jedis jedis){
		if (null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}
}
