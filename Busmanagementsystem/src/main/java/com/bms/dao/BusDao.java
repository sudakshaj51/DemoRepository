package com.bms.dao;
/** Here we are using Bus interface 
 * in this we write only Bus methods*/
import java.util.List;

import com.bms.bean.Bus;

public interface BusDao {
	
	public void addBus();
	public Bus viewBus(int bid);
	public List<Bus> viewAllBuses();
	public void deleteBus(int bid);
	public void updateBus(int bid);
	public void back();
}
