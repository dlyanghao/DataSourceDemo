package com.yanghao.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * �ǹ�ϵ�����ݿ�Redis������
 * @author YanoHao
 *
 */
public class DatabaseUtil {
	
	private static JedisPool jedisPool;
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		//���ó������ɵ����������Ϊ10��
		config.setMaxTotal(10);
		//��������������
		config.setMaxIdle(5);
		
		jedisPool = new JedisPool(config, "localhost", 6379);
	}
	
	/**
	 * ��ȡJedis����
	 * @return
	 */
	public static Jedis getJedis(){
		
		
		Jedis jedis = jedisPool.getResource();
		return jedis;
		
	}
	
	
	
	

}
