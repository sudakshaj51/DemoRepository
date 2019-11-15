package com.bms.bean;

import java.sql.Timestamp;
import java.util.Date;
/**Here we are using Reserve bean class 
 * In this class Reservation variable columns are present
 * In this class we use constructor and setter getter methods*/
public class Reserve {
	
	private int tid;
	private int seat;
	private Timestamp timestamp;
	private int pid;
	private int bid;
	private Date date;
	private String status;
	
public Reserve(){
}

public Reserve(int tid, int seat, Timestamp timestamp, int pid, int bid, Date date, String status) {
	super();
	this.tid = tid;
	this.seat = seat;
	this.timestamp = timestamp;
	this.pid = pid;
	this.bid = bid;
	this.date = date;
	this.status=status;
	
}





public int getTid() {
	return tid;
}

public void setTid(int tid) {
	this.tid = tid;
}

public int getSeat() {
	return seat;
}

public void setSeat(int seat) {
	this.seat = seat;
}

public Timestamp getTimestamp() {
	return timestamp;
}

public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public int getBid() {
	return bid;
}

public void setBid(int bid) {
	this.bid = bid;
}


	public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


	public String toString(){
		return tid+"\t"+seat+"\t"+timestamp+"\t"+pid+"\t"+bid+"\t"+date+"\t"+status;
	}

}
