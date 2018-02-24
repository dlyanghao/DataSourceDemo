package com.yanghao.util.tool;

import java.sql.Connection;

import org.junit.Test;

public class DatabaseUtilTest {
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

}
