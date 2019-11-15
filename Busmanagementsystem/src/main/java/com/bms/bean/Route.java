package com.bms.bean;
/**Here we are using Route bean class 
 * In this class Route variable columns are present
 * In this class we use constructor and setter getter methods*/
public class Route {
	
		private int rid;
		private String fromplace;
		private String toplace;
		private String status;
		
public Route(){
}

public Route(int rid, String fromplace, String toplace, String status) {
	super();
	this.rid = rid;
	this.fromplace = fromplace;
	this.toplace = toplace;
	this.status=status;
}



public int getRid() {
	return rid;
}

public void setRid(int rid) {
	this.rid = rid;
}


	public String getFromplace() {
	return fromplace;
}

public void setFromplace(String fromplace) {
	this.fromplace = fromplace;
}

public String getToplace() {
	return toplace;
}

public void setToplace(String toplace) {
	this.toplace = toplace;
}

	public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	public String toString(){
		return rid+"\t"+fromplace+"\t"+toplace+"\t"+status;
	}

}
