package com.bms.dao;
/** Here we are using Reserve interface 
 * in this we write only Reserve methods*/
import java.util.List;

import com.bms.bean.Reserve;

public interface ReserveDao {
	
public void addReserve();
public Reserve viewReserve(int tid);
public List<Reserve> viewAllReservations();
public void updateReservation(int tid);
public void deleteReservations(int tid);

public void back();

public void bill();
}
