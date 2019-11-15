package com.phs.bean;

public class Pizza {
	
	private int pid;
	private String pname;
	private String type;
	private int qty;
	private double price;
	
	public Pizza() {}
	public Pizza(int pid,String pname,String type,int qty,double price) {
		this.pid=pid;
		this.pname=pname;
		this.type=type;
		this.qty=qty;
		this.price=price;
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return pid+"\t"+pname+"\t"+type+"\t"+qty+"\t"+price;
	}

}
