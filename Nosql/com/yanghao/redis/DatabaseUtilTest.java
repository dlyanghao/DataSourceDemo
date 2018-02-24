package com.yanghao.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class DatabaseUtilTest {

	@Test
	public void test() {
		Jedis jedis = DatabaseUtil.getJedis();
		//���Բ�������
		jedis.set("1", "abc");
		jedis.close();
		
	}
	@Test
	public void test1() {
		Jedis jedis = DatabaseUtil.getJedis();
		//���Ի�ȡ����
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
