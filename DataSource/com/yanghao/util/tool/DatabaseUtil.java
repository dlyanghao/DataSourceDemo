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
	 * 通过自定义工具类来获取连接对象，关闭连接对象
	 * (MYSQL数据库驱动工具类)
	 * @author YanoHao
	 * 
	 */
	private static String url;
	private static String user;
	private static String password;
	
	//加载数据库连接驱动及属性文件
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
			System.err.println("找不到数据库加载所需要的类");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.err.println("找不到数据库加载所需要的属性文件");
			e.printStackTrace();
		}
	}
	
	
	//获取连接对象
	public static Connection getConnection(){
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
			
		} catch (SQLException e) {
			System.err.println("获取Connection对象失败");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	//关闭建立的连接对象，释放资源
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
