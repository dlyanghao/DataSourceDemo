package com.yanghao.druid;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DatabaseUtilTest {

	@Test
	public void test() throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		System.out.println("ͨ��druid���ӳػ�ȡ���Ӷ���ɹ�");
		DatabaseUtil.closeSourceConnection(connection, null, null);
	}

}
