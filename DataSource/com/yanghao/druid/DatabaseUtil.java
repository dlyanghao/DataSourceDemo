package com.yanghao.druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * 封装druid连接池创建工具类
 */
public class DatabaseUtil {

	/**
	 * 数据库连接池（druid连接池）对象引用
	 */
	private static DataSource druidPool;

	static {

		try {
			Properties properties = new Properties();
			ClassLoader classLoader = DatabaseUtil.class.getClassLoader();
			InputStream resourceAsStream = classLoader.getResourceAsStream("druidconfig.properties");
			properties.load(resourceAsStream);
			// 通过直接创建连接池对象的方式创建连接池对象
			// DruidDataSource druidDataSource = new DruidDataSource();
			// druidDataSource.setUsername(properties.getProperty("username"));
			// druidDataSource.setPassword(properties.getProperty("password"));
			// druidDataSource.setUrl(properties.getProperty("url"));
			// druidDataSource.setDriverClassName(properties.getProperty("driverClassName"));
			// druidPool = druidDataSource;
			// 通过工厂的方式创建连接池对象
			druidPool = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection connection = druidPool.getConnection();
		return connection;

	}

	/**
	 * 
	 * 关闭建立的连接对象，释放资源
	 */
	public static void closeSourceConnection(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static DataSource getDruidPool() {
		return druidPool;
	}

}
