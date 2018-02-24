package com.yanghao.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class DatabaseUtilTest {

	@Test
	public void test() {
		Jedis jedis = DatabaseUtil.getJedis();
		//测试插入数据
		jedis.set("1", "abc");
		jedis.close();
		
	}
	@Test
	public void test1() {
		Jedis jedis = DatabaseUtil.getJedis();
		//测试获取数据
		String string = jedis.get("1");
		System.out.println(string);
		jedis.close();
	}
	@Test
	public void test2() {
		Jedis jedis = DatabaseUtil.getJedis();
		jedis.del("1");
		String result = jedis.get("1");
		System.out.println(result);
		jedis.close();	
	}

}
