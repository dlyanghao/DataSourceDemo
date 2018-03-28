package com.yanghao.util.tool;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DatabaseUtilTest {
	private Statement createStatement;

	/**
	 * @author YanoHao
	 * 单元测试要注意的三点：
	 * 1测试函数不能有返回值
	 * 2测试函数不能有参数
	 * 3测试函数一定是以public修饰的
	 */

	@Test
	public void test() {
		Connection connection = DatabaseUtil.getConnection();
		DatabaseUtil.closeSourceConnection(connection, null, null);
		
	}
	
	@Test
	public void oracleTest() throws SQLException{
		Connection connection = DatabaseUtil.getConnection();
		createStatement = connection.createStatement();
		ResultSet rs = createStatement.executeQuery("select * from counts");
		while (rs.next()) {
			String username = rs.getString(2);
			String password = rs.getString(3);
			String description = rs.getString(4);
			System.out.println(username+password+description);
		}
		DatabaseUtil.closeSourceConnection(connection, null, null);
	}

}
