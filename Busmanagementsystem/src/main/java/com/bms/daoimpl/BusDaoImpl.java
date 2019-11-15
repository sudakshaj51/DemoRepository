package com.bms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.bms.bean.Bus;
import com.bms.dao.BusDao;
import com.bms.main.BusManagementSystem;
import com.bms.query.Query;
import com.bms.util.DBUtil;
/**  here we are implementing the Bus methods*/
public class BusDaoImpl implements BusDao {
	PreparedStatement ps = null;
	Connection con = DBUtil.getConnection();
	Bus bus = null;
	List<Bus> buses = null;
	Scanner sc = new Scanner(System.in);
	/**Here we are adding the bus*/
	@Override
	public void addBus() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_bus);
				System.out.println("Enter bus id ?");
				String bid = sc.next();
				while(!Pattern.matches("\\d{4}",bid)) {
					System.err.println("pleas enter bus id should be 4 digits only ex:1111 ");
					bid =sc.next();	
				}
				 int no = Integer.parseInt(bid);
			     ps.setInt(1, no);
			     System.out.println("Enter bus type ?");
					String type = sc.next();
					while (!Pattern.matches("[ACORNonac]+", type)) {
						System.err.println("pleas enter bus type (ac or nonac) only");
						type =sc.next();
					}
					ps.setString(2, type);
					System.out.println("Enter bus fare ?");
					String fare = sc.next();
					while(!Pattern.matches("\\d+",fare)) {
						System.err.println("please enter price should be in digits only ex:1000 rs ");
						fare =sc.next();	
					}
					 double price = Double.parseDouble(fare);
					ps.setDouble(3,price);
				System.out.println("Enter bus depttime ?");
				ps.setString(4, sc.next());
				System.out.println("Enter bus arvtime ?");
				ps.setString(5, sc.next());
				System.out.println("Enter bus route id ?");
				///int rid = sc.nextInt();
				//while(!Pattern.matches("\\d{6}",rid)) {
					//System.err.println("please enter bus id should be 4 digits only ex:1111 ");
					//rid =sc.nextInt();	
				//}
				// int reservationid = Integer.parseInt(rid);
				ps.setInt(6,sc.nextInt());
				ps.setString(7, "Active");
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
					//con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/**view the bus*/
	@Override
	public Bus viewBus(int bid) {
		Bus bus = new Bus();
		try {
			ps = con.prepareStatement(Query.view_bus);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bus.setBid(rs.getInt(1));
				bus.setType(rs.getString(2));
				bus.setFare(rs.getInt(3));
				bus.setDepttime(rs.getString(4));
				bus.setArvtime(rs.getString(5));
				bus.setStatus(rs.getString("status"));
				bus.setRid(rs.getInt(6));
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
		return bus;
	
	}
	/** view all buses*/
	@Override
	public List<Bus> viewAllBuses() {
		buses = new ArrayList<Bus>();
		Bus b = null;
		try {
			ps = con.prepareStatement(Query.view_all_buses);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				b = new Bus();
				b.setBid(rs.getInt(1));
				b.setType(rs.getString(2));
				b.setFare(rs.getInt(3));
				b.setDepttime(rs.getString(4));
				b.setArvtime(rs.getString(5));
				b.setRid(rs.getInt(6));
				b.setStatus(rs.getString("status"));
				buses.add(b);
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
		return buses;
		
	}
	/** delete the bus*/
	@Override
	public void deleteBus(int bid) {
		try {
			ps=con.prepareStatement(Query.delete_bus);
			System.out.println("Enter deleting bus id");
			ps.setInt(1, bid);
			int n=ps.executeUpdate();
			if(n!=0){
				System.out.println("Bus successfully deleted");
			}else{
				System.out.println("not able to delete the bus please try again");
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
	/**Update the bus*/
	@Override
	public void updateBus(int bid) {
		int n=0;
		System.out.println("Enter your choice 1.Bus id 2.Bus type");
		int choice=sc.nextInt();
	    try {
			switch(choice){
			case 1:
			
				ps=con.prepareStatement(Query.update_bus_id);
				   System.out.println("Enter Updating bus id ?");
				   ps.setInt(1,sc.nextInt());
				   ps.setInt(2,bid);
				   n=ps.executeUpdate();
				   if(n!=0)
				   {
					   System.out.println("Bus id Updated Successfully");
				   }else{
					   System.out.println("Bus id Not Updated.Please try again");
				   }
				   break;
			case 2:
				ps=con.prepareStatement(Query.update_bus_type);
				System.out.println("Enter updating bus type ?");
				ps.setString(1, sc.next());
				ps.setInt(2, bid);
				n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Bus type is updated successfully");
				}else{
					System.out.println("Bus type is not able to update please try again");
				}
				break;
				default:System.out.println("Please select choice range only 1-2");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**back method*/
	@Override
	public void back() {
		BusManagementSystem.main(null);
		
	}
	
}
