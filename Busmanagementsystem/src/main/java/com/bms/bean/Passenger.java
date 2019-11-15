package com.bms.bean;
/** Here we are using passenger bean class
 * in this class passenger variable columns are present*/
public class Passenger {
	
	private int pid;
	private String username;
	private String password;
	private String name;
	private String mobile;
	private String email;
	private String status;
public Passenger(){
}
public Passenger(int pid, String username, String password, String name, String mobile, String email, String status) {
	super();
	this.pid = pid;
	this.username = username;
	this.password = password;
	this.name = name;
	this.mobile = mobile;
	this.email = email;
	this.status=status;
}


public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
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
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String toString(){
	return pid+"\t"+username+"\t"+password+"\t"+name+"\t"+mobile+"\t"+email+"\t"+status;
}
}
