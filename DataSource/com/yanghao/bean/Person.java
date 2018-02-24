package com.yanghao.bean;

/**
 * 
 * @author YanoHao
 *
 * 
 */
public class Person {
	/**
	 * name �û�����
	 */
	private String name;
	/**
	 * password ��������
	 */
	private String password;
	/**
	 * description �û�����
	 */
	private String description;
	
	
	private int type;
	
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 
	 */
	public Person() {

	}
	
	/**
	 * 
	 * @param name
	 * @param password
	 * @param description
	 */
	public Person(String name, String password, String description) {
		this.name = name;
		this.password = password;
		this.description = description;
	}
	
	

	/**
	 * 
	 * @return �û���
	 * 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * �����û���
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return �û�����
	 * 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *
	 * �����û�����
	 *  
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return �û���ϸ��Ϣ
	 * 
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * �����û���ϸ��Ϣ
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return ��Ա�����ԵĵĴ�ӡ��Ϣ
	 * 
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", description=" + description + "]";
	}


}
