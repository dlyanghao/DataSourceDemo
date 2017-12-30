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
 * (封装dbcp连接池来创建数据库工具类)
 * @author YanoHao
 * (属性文件为源文件夹properties下的dbcpconfig.properties)
 */
public class DatabaseUtil {
	
	/**
	 * 数据库连接池（dbcp连接池）对象引用
	 */
	private static DataSource dbcpPoor;
	
	/**
	 * 只执行一次
	 */
	static {
		Properties properties = new Properties();
		ClassLoader classLoader = DatabaseUtil.class.getClassLoader();
		InputStream resourceAsStream = classLoader.getResourceAsStream("dbcpconfig.properties");
		try {
			properties.load(resourceAsStream);
			
			//通过直接创建连接池对象并设置参数方法创建连接池对象
//			BasicDataSource basicDataSource = new BasicDataSource();
//			basicDataSource.setUsername(properties.getProperty("username"));
//			basicDataSource.setPassword(properties.getProperty("password"));
//			basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
//			basicDataSource.setUrl(properties.getProperty("url"));
//			
//			dbcpPoor = basicDataSource;
			
			//通过工厂的方法创建连接池对象
//			dbcpPoor = BasicDataSourceFactory.createDataSource(properties);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		Connection connection = dbcpPoor.getConnection();
		System.out.println("获取连接对象成功");
		return connection;
	}
	
	/**
	 * 关闭资源
	 */
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

	public static DataSource getDbcpPoor() {
		return dbcpPoor;
	}
	
}
