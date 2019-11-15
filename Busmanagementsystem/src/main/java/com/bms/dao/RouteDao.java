package com.bms.dao;
/** Here we are using Route interface 
 * in this we write only Route methods*/
import java.util.List;

import com.bms.bean.Route;

public interface RouteDao {
	
public void addRoute();
public Route viewRoute(int rid);
public List<Route> viewAllRoutes();
public void updateRoute(int rid);
public void deleteRoute(int rid);
public void back();
}
