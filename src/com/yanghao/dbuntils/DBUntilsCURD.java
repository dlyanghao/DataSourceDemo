package com.yanghao.dbuntils;

import static org.hamcrest.CoreMatchers.not;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.yanghao.bean.Person;
import com.yanghao.c3p0.DatabaseUtil;

public class DBUntilsCURD {

	public static void main(String[] args) throws SQLException {
		
		//DBUtils(���ݿ���)ʹ��c3p0���ӳ����������ݿ�
		DBUntilsCURD dbUntilsCURD = new DBUntilsCURD();
		
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
