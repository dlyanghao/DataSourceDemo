package com.yanghao.util.tool;

import java.sql.Connection;

import org.junit.Test;

public class DatabaseUtilTest {
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

}
