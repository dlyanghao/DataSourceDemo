package com.yanghao.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * (��װdbcp���ӳ����������ݿ⹤����)
 * @author YanoHao
 * (�����ļ�ΪԴ�ļ���properties�µ�dbcpconfig.properties)
 */
public class DatabaseUtil {
	
	/**
	 * ���ݿ����ӳأ�dbcp���ӳأ���������
	 */
	private static DataSource dbcpPoor;
	
	/**
	 * ִֻ��һ��
	 */
	static {
		Properties properties = new Properties();
		ClassLoader classLoader = DatabaseUtil.class.getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("dbcpconfig.properties");
		try {
			properties.load(resourceAsStream);
			
			//ͨ��ֱ�Ӵ������ӳض������ò��������������ӳض���
//			BasicDataSource basicDataSource = new BasicDataSource();
//			basicDataSource.setUsername(properties.getProperty("username"));
//			basicDataSource.setPassword(properties.getProperty("password"));
//			basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
//			basicDataSource.setUrl(properties.getProperty("url"));
//			
//			dbcpPoor = basicDataSource;
			
			//ͨ�������ķ����������ӳض���
//			dbcpPoor = BasicDataSourceFactory.createDataSource(properties);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		Connection connection = dbcpPoor.getConnection();
		System.out.println("��ȡ���Ӷ���ɹ�");
		return connection;
	}
	
	/**
	 * �ر���Դ
	 */
	//�رս��������Ӷ����ͷ���Դ
		public static void closeSourceConnection(Connection connection, Statement statement, ResultSet resultSet){
			
			try {
				if (connection!=null) {
					connection.close();
				}
				if (statement!=null) {
					statement.close();
				}
				if (resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	public static DataSource getDbcpPoor() {
		return dbcpPoor;
	}
	
}
