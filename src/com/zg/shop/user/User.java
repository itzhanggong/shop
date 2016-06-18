package com.zg.shop.user;

/*CREATE TABLE USER
(
   uid                   INT PRIMARY KEY AUTO_INCREMENT,
   username             VARCHAR(20) COMMENT '用户名',
   PASSWORD             VARCHAR(20) COMMENT '密码',
   NAME                 VARCHAR(20) COMMENT '真实姓名',
   email                VARCHAR(30) COMMENT '用户邮箱',
   phone                VARCHAR(20) COMMENT '用户电话',
   addr                 VARCHAR(50) COMMENT '用户地址',
   sex                  VARCHAR(10) COMMENT '用户性别，1男，2女',
   state                INT COMMENT '用户状态，1未激活，2激活',
   CODE                 VARCHAR(64) COMMENT '注册用户时生成的激活码'
);*/
/**
 * @author Administrator
 *
 */
public class User {
	private Integer uid;
	private String username;
	private String password; 
	private String name;
	private String email;
	private String phone;
	private String addr;
	private String sex;
	private String state;
	private String code;
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
