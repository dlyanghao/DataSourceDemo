package com.yanghao.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 非关系型数据库Redis工具类
 * @author YanoHao
 *
 */
public class DatabaseUtil {
	
	private static JedisPool jedisPool;
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		//设置池子容纳的最大连接数为10个
		config.setMaxTotal(10);
		//设置最大空闲数量
		config.setMaxIdle(5);
		
		jedisPool = new JedisPool(config, "localhost", 6379);
	}
	
	/**
	 * 获取Jedis对象
	 * @return
	 */
	public static Jedis getJedis(){
		
		
		Jedis jedis = jedisPool.getResource();
		return jedis;
		
	}
	
	
	
	

}
