package com.yanghao.bean;

/**
 * 
 * @author YanoHao
 *
 * 
 */
public class Person {
	/**
	 * name 用户名字
	 */
	private String name;
	/**
	 * password 名字密码
	 */
	private String password;
	/**
	 * description 用户介绍
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
	 * @return 用户名
	 * 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * 设置用户名
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return 用户密码
	 * 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 *
	 * 设置用户密码
	 *  
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return 用户详细信息
	 * 
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * 设置用户详细信息
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 * @return 成员各属性的的打印信息
	 * 
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", description=" + description + "]";
	}


}
