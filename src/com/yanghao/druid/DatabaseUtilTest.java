package com.yanghao.druid;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DatabaseUtilTest {

	@Test
	public void test() throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		System.out.println("通过druid连接池获取连接对象成功");
		DatabaseUtil.closeSourceConnection(connection, null, null);
	}

}
