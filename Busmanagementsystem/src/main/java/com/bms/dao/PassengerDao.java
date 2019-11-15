package com.bms.dao;
/** Here we are using Passenger interface 
 * in this we write only Passenger methods*/
import java.util.List;

import com.bms.bean.Passenger;

public interface PassengerDao {
	
public void addPassenger();
public Passenger viewPassenger(int pid);
public List<Passenger> viewAllPassengers();
public void updatePassenger(int pid);
public void deletePassenger(int pid);
public void back();
}
