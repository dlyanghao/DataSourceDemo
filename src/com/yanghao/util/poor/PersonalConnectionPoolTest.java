package com.yanghao.util.poor;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class PersonalConnectionPoolTest {

	@Test
	public void test() throws SQLException {
		PersonalConnectionPool personalConnectionPool = new PersonalConnectionPool();
		
		Connection connection1 = personalConnectionPool.getConnection();
		Connection connection2 = personalConnectionPool.getConnection();
		Connection connection3 = personalConnectionPool.getConnection();
		Connection connection4 = personalConnectionPool.getConnection();
		Connection connection5 = personalConnectionPool.getConnection();
		
		connection1.close();
		connection2.close();
		connection3.close();
		connection4.close();
		connection5.close();
		
	}

}
