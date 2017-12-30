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
		
		//DBUtils(数据库框架)使用c3p0连接池来操作数据库
		DBUntilsCURD dbUntilsCURD = new DBUntilsCURD();
		
		//添加数据到数据库中
//		String sql = "insert into person values(?,?,?,?)";
//		Object[] params = {null,"李白","123","喝酒"};
//		dbUntilsCURD.updataDatabase(sql, params);
		
		
		//查询一条数据结果存放到Person类中
//		String sql1 = "select * from person where id=?";
//		Object[] params1 = {4};
//		//Person person = dbUntilsCURD.queryDatabase(sql1, new BeanHandler<Person>(Person.class), params1);
//		//System.out.println(person.getPassword());
		
		//查询多条数据把数据结果存到list集合中
//		String sql2 = "select * from person";
//		Object[] params2 = {};
//		List<Person> list = dbUntilsCURD.queryDatabase(sql2, new BeanListHandler<Person>(Person.class),params2);
//		System.out.println(list.toString());
		
		//查询单个数据
//		String sql3 = "select name from person where id=?";
//		Object[] params3 = {4};
//		String name = (String) dbUntilsCURD.queryDatabase(sql3, new ScalarHandler(), params3);
//		System.out.println(name);
		
	}
	
	
	
	/**
	 * 更新数据库
	 * @throws SQLException 
	 */
	
	@Test
	public void updataDatabase(String sql, Object... params) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		queryRunner.update(sql,params);
	}
	
	
	
	/**
	 * 查询数据库,根据传入不同ResultSetHandler把结果保存到你需要变量、JavaBean对象、JavaBean集合List等等中
	 * @throws SQLException 
	 */
	
	public <T> T queryDatabase(String sql, ResultSetHandler<T> rsh,Object... params) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(DatabaseUtil.getC3p0Poor());
		return queryRunner.query(sql, rsh, params);
		
	}
	

}
