package com.yanghao.client;

import java.util.Scanner;

import com.yanghao.server.Server;

public class Client {
	
	/**
	 * 
	 * (模拟客户端)
	 * @author YanoHao
	 */
	
	public static void main(String[] args) {
		
		System.out.println("欢迎使用模拟客户端小程序，该程序用来测试使用数据库工具类");		
		System.out.println("------------------------------------请按照提示输入数据：");
		System.out.println("请输入你的用户名:");
		
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		
		System.out.println("请输入你的密码:");
		String password = scanner.nextLine();
		
		Server server = new Server();
		boolean flag = server.login(username, password);
		scanner.close();
		
		
		if(flag){
			System.out.println("登录成功");
		}
		else
		{
			System.out.println("登录失败");
		}
		
		
	}
	
	
}
