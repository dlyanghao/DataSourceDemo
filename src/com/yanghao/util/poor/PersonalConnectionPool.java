package com.yanghao.util.poor;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Demo class
 * �Զ�������ӳ�--�ṩ���Ӷ���
 * @author YanoHao
 * @date 2017/12/29
 */
public class PersonalConnectionPool {
	
	/**
	 * �û���
	 */
	private static String user;
	/**
	 * ����
	 */
	private static String password;
	/**
	 * �������ݿ��URL
	 */
	private static String url;
	
	
	/**
	 * ���ӳ�
	 * �涨���������Ϊ3
	 */
	private static LinkedList<Connection> pool;
	
	/**
	 * �������ݿ���������ʼ�����ӳ�
	 */
	static{
		
		try {
			Properties properties = new Properties();
			pool = new LinkedList<Connection>();
			Class.forName("com.mysql.jdbc.Driver");
			ClassLoader classLoader = PersonalConnectionPool.class.getClassLoader();
			InputStream iStream = classLoader.getResourceAsStream("mysqlCongfig.properties");
			properties.load(iStream);
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			url = properties.getProperty("url");
			//�����������Ӷ��󣨰�װ����󣩷ŵ�������
			for (int i = 0; i < 3; i++) {
				Connection connection = DriverManager.getConnection(url, user, password);
				Connection connectionWrapper = new ConnectionWapper(connection,pool);
				pool.add(connectionWrapper);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @throws SQLException 
	 * @method �����ṩ���Ӷ���
	 */
	public Connection getConnection() throws SQLException {
		
		Connection connection;
		
		if(pool.size()>0)
		{
			
			connection = pool.removeFirst();
			
		}
		else
		{
			//�ȴ���ʱ������һ���´����Ķ���
			connection = DriverManager.getConnection(url, user, password);
		}
		System.out.println("��ǰ��������  "+pool.size()+" ������");
		return connection;
	}
	
	/**
	 * �黹���Ӷ���
	 * ֱ�Ӽ��ڰ�װ���close������
	 */
}