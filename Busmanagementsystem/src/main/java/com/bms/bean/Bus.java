package com.bms.bean;
/**Here we are using Bus bean class 
 * In this class Bus variable columns are present
 * In this class we use constructor and setter getter methods*/
public class Bus {
	
      private int bid;
      private String type;
      private int fare;
      private String depttime;
      private String arvtime;
      private int rid;
      private String status;

public Bus(){
}

public Bus(int bid, String type, int fare, String depttime, String arvtime, int rid,String status) {
	super();
	this.bid = bid;
	this.type = type;
	this.fare = fare;
	this.depttime = depttime;
	this.arvtime = arvtime;
	this.rid = rid;
	this.status=status;
}



public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getBid() {
	return bid;
}

public void setBid(int bid) {
	this.bid = bid;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getFare() {
	return fare;
}

public void setFare(int fare) {
	this.fare = fare;
}

public String getDepttime() {
	return depttime;
}

public void setDepttime(String depttime) {
	this.depttime = depttime;
}

public String getArvtime() {
	return arvtime;
}

public void setArvtime(String arvtime) {
	this.arvtime = arvtime;
}

public int getRid() {
	return rid;
}

public void setRid(int rid) {
	this.rid = rid;
}
public String toString(){
	return bid+"\t"+type+"\t"+fare+"\t"+depttime+"\t"+arvtime+"\t"+rid+"\t"+status;
}
}