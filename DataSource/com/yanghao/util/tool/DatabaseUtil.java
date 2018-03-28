package com.yanghao.util.tool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.yanghao.constant.Constant;

public class DatabaseUtil {
	
	/**
	 * ͨ���Զ��幤��������ȡ���Ӷ��󣬹ر����Ӷ���
	 * (MYSQL���ݿ�����������)
	 * @author YanoHao
	 * 
	 */
	private static String url;
	private static String user;
	private static String password;
	
	//�������ݿ����������������ļ�
	static{
		try {
			Class.forName(Constant.ORACLE_DRIVER_QUALIFIEDNAME);
			Properties properties = new Properties();
			ClassLoader classLoader = DatabaseUtil.class.getClassLoader();
			InputStream resourceAsStream = classLoader.getResourceAsStream("myCongfig.properties");
			properties.load(resourceAsStream);
			
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		} catch (ClassNotFoundException e) {
			System.err.println("�Ҳ������ݿ��������Ҫ����");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.err.println("�Ҳ������ݿ��������Ҫ�������ļ�");
			e.printStackTrace();
		}
	}
	
	
	//��ȡ���Ӷ���
	public static Connection getConnection(){
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
			
		} catch (SQLException e) {
			System.err.println("��ȡConnection����ʧ��");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
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
	
}
