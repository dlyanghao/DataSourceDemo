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
	 * ��Ԫ����Ҫע������㣺
	 * 1���Ժ��������з���ֵ
	 * 2���Ժ��������в���
	 * 3���Ժ���һ������public���ε�
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
