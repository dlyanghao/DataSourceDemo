package com.yanghao.dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.yanghao.bean.Person;
import com.yanghao.c3p0.DatabaseUtil;

public class DBUtilsCURD {

	public static void main(String[] args) throws SQLException {
		
		//DBUtils(���ݿ���)ʹ��c3p0���ӳ����������ݿ�
		DBUtilsCURD dbUntilsCURD = new DBUtilsCURD();
		
		//������ݵ����ݿ���
//		String sql = "insert into person values(?,?,?,?)";
//		Object[] params = {null,"���","123","�Ⱦ�"};
//		dbUntilsCURD.updataDatabase(sql, params);
		
		
		//��ѯһ�����ݽ����ŵ�Person����
//		String sql1 = "select * from person where id=?";
//		Object[] params1 = {4};
//		//Person person = dbUntilsCURD.queryDatabase(sql1, new BeanHandler<Person>(Person.class), params1);
//		//System.out.println(person.getPassword());
		
		//��ѯ�������ݰ����ݽ���浽list������
//		String sql2 = "select * from person";
//		Object[] params2 = {};
//		List<Person> list = dbUntilsCURD.queryDatabase(sql2, new BeanListHandler<Person>(Person.class),params2);
//		System.out.println(list.toString());
		
		//��ѯ��������
//		String sql3 = "select name from person where id=?";
//		Object[] params3 = {4};
//		String name = (String) dbUntilsCURD.queryDatabase(sql3, new ScalarHandler(), params3);
//		System.out.println(name);
		
		//��ѯ�����û����룬�ѽ������10����
		
		String sql4 = "select type*10 from person";
		List<Person> queryDatabase = dbUntilsCURD.queryDatabase(sql4, new BeanListHandler<Person>(Person.class));
		System.out.println(queryDatabase.toString());
	}
	
	
	
	/**
	 * �������ݿ�
	 * @throws SQLException 
	 */
	@Test
	public void updataDatabase(String sql, Object... params) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		queryRunner.update(sql,params);
	}
	
	
	
	/**
	 * ��ѯ���ݿ�,���ݴ��벻ͬResultSetHandler�ѽ�����浽����Ҫ������JavaBean����JavaBean����List�ȵ���
	 * @throws SQLException 
	 */
	
	public <T> T queryDatabase(String sql, ResultSetHandler<T> rsh,Object... params) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		return queryRunner.query(sql, rsh, params);
		
	}
	
	

}
