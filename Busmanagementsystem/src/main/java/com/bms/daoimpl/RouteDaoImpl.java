package com.bms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bms.bean.Passenger;
import com.bms.bean.Route;
import com.bms.dao.RouteDao;
import com.bms.main.BusManagementSystem;
import com.bms.query.Query;
import com.bms.util.DBUtil;

public class RouteDaoImpl implements RouteDao {
	PreparedStatement ps = null;
	Connection con = DBUtil.getConnection();
	Route route = null;
	List<Route> routes = null;
	Scanner sc = new Scanner(System.in);
	@Override
	public void addRoute() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_route);
				System.out.println("Enter route id ?");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter  route from ?");
				ps.setString(2, sc.next());
				System.out.println("Enter route to ?");
				ps.setString(3, sc.next());
				ps.setString(4, "Active");
				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("One Record Inserted Successfully...");
				} else {
					System.out.println("Record Not Inserted. Please try again");
				}
				System.out.println("Do you want to add more record press 1 else any number");
				i = sc.nextInt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public Route viewRoute(int rid) {
		Route route = new Route();
		try {
			ps = con.prepareStatement(Query.view_route);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				route.setRid(rs.getInt(1));
				route.setFromplace(rs.getString(2));
				route.setToplace(rs.getString(3));
				route.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				//con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return route;
	}

	@Override
	public List<Route> viewAllRoutes() {
		routes = new ArrayList<Route>();
		Route r = null;
		try {
			ps = con.prepareStatement(Query.view_all_routes);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				r = new Route();
				r.setRid(rs.getInt(1));
				r.setFromplace(rs.getString(2));
				r.setToplace(rs.getString(3));
			    r.setStatus(rs.getString("status"));
				routes.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				//con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return routes;
	}

	@Override
	public void updateRoute(int rid) {
		int n=0;
		System.out.println("Enter your choice 1.fromplace 2.toplace");
		int choice=sc.nextInt();
		try {
			switch(choice){
			case 1:
				    ps=con.prepareStatement(Query.update_from);
				    System.out.println("Enter updating from place ");
				    ps.setString(1, sc.next());
				    ps.setInt(2, rid);
				    n=ps.executeUpdate();
				    if(n!=0){
				    	System.out.println("From place successfully updated");
				    }else
				    {
				    	System.out.println("From place not able updated Please try again");
				    }
				    break;
			case 2:
				   ps=con.prepareStatement(Query.update_to);
				   System.out.println("Enter updating to place ");
				   ps.setString(1, sc.next());
				   ps.setInt(2, rid);
				   n=ps.executeUpdate();
				   if(n!=0){
					   System.out.println("to place successfully updated");
				   }else
				   {
					   System.out.println("to place not able update please try again");
				   }
				   break;
				   default:System.out.println("Please select choice range 1-2 only");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRoute(int rid) {
		try {
			ps=con.prepareStatement(Query.delete_route);
			System.out.println("Enter deleting route");
			ps.setInt(1, rid);
			int n=ps.executeUpdate();
			if(n!=0){
				System.out.println("Route deleted successfully");
			}else{
				System.out.println("Not able to delete the Route please try again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void back() {
		BusManagementSystem.main(null);
		
	}

}
