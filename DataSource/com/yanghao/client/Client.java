package com.yanghao.client;

import java.util.Scanner;

import com.yanghao.server.Server;

public class Client {
	
	/**
	 * 
	 * (ģ��ͻ���)
	 * @author YanoHao
	 */
	
	public static void main(String[] args) {
		
		System.out.println("��ӭʹ��ģ��ͻ���С���򣬸ó�����������ʹ�����ݿ⹤����");		
		System.out.println("------------------------------------�밴����ʾ�������ݣ�");
		System.out.println("����������û���:");
		
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		
		System.out.println("�������������:");
		String password = scanner.nextLine();
		
		Server server = new Server();
		boolean flag = server.login(username, password);
		scanner.close();
		
		
		if(flag){
			System.out.println("��¼�ɹ�");
		}
		else
		{
			System.out.println("��¼ʧ��");
		}
		
		
	}
	
	
}
