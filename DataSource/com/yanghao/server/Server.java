package com.yanghao.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yanghao.util.tool.DatabaseUtil;

public class Server {
	
	/**
	 * (Ä£Äâ·þÎñÆ÷)
	 * @author YanoHao
	 */
	
	public boolean login(String username, String password){
		
		boolean flag = false;
		try {
			Connection connection = DatabaseUtil.getConnection();
			String sql="select * from _user where _username=? and _password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				flag = true;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
	


}
