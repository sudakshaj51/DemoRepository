package com.bms.daoimpl;
/**Here we are implementing the Passe*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.bms.bean.Bus;
import com.bms.bean.Passenger;
import com.bms.dao.PassengerDao;
import com.bms.main.BusManagementSystem;
import com.bms.query.Query;
import com.bms.util.DBUtil;

public class PassengerDaoImpl implements PassengerDao{
	PreparedStatement ps = null;
	Connection con = DBUtil.getConnection();
	Passenger passenger = null;
	List<Passenger> passengers = null;
	Scanner sc = new Scanner(System.in);
	@Override
	public void addPassenger() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_passenger);
				System.out.println("Enter passenger id ?       ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter  passenger username ?");
				ps.setString(2, sc.next());
				System.out.println("Enter passenger password ? ");
				ps.setString(3, sc.next());
				System.out.println("Enter passenger name ?     ");
				ps.setString(4, sc.next());
				System.out.println("Enter passenger mobile ?   ");
				ps.setString(5, sc.next());
				System.out.println("Enter Passeanger email ?   ");
				 String email = sc.next();
					while (!Pattern.matches("\\w*+@+[a-z]{5}+.+[a-z]{3}", email)) {
						System.err.println("please enter vaild email id ?");
						email =sc.next();
					}
				 ps.setString(6, email);
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

	@Override
	public Passenger viewPassenger(int pid) {
		// TODO Auto-generated method stub
		Passenger passenger = new Passenger();
		try {
			ps = con.prepareStatement(Query.view_passenger);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				passenger.setPid(rs.getInt(1));
				passenger.setUsername(rs.getString(2));
				passenger.setName(rs.getString(3));
				passenger.setPassword(rs.getString(4));
				passenger.setMobile(rs.getString(5));
				passenger.setEmail(rs.getString(6));
				passenger.setStatus(rs.getString("status"));
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
		
		return passenger;
	}

	@Override
	public List<Passenger> viewAllPassengers() {
		// TODO Auto-generated method stub
		passengers = new ArrayList<Passenger>();
		Passenger p = null;
		try {
			ps = con.prepareStatement(Query.view_all_passengers);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				p = new Passenger();
				p.setPid(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setName(rs.getString(4));
				p.setMobile(rs.getString(5));
				p.setEmail(rs.getString(6));
				p.setStatus(rs.getString("status"));
				passengers.add(p);
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
		
		return passengers;
	}

	@Override
	public void updatePassenger(int pid) {
		// TODO Auto-generated method stub
		int n=0;
		System.out.println("Enter your choice 1.pid 2.username 3.password 4.name 5.mobile 6.email");
		int choice=sc.nextInt();
	    try {
			switch(choice){
			case 1:
			
				ps=con.prepareStatement(Query.update_passenger_id);
				   System.out.println("Enter Updating passenger id ?");
				   ps.setInt(1,sc.nextInt());
				   ps.setInt(2,pid);
				   n=ps.executeUpdate();
				   if(n!=0)
				   {
					   System.out.println("Passenger id Updated Successfully");
				   }else{
					   System.out.println("Passenger id Not Updated.Please try again");
				   }
				   break;
			case 2:
				ps=con.prepareStatement(Query.update_passenger_username);
				System.out.println("Enter updating passenger username ?");
				ps.setString(1, sc.next());
				ps.setInt(2, pid);
				n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Passenger username is updated successfully");
				}else{
					System.out.println("Passenger username is not able to update please try again");
				}
				break;
			case 3:
				ps=con.prepareStatement(Query.update_passenger_name);
				System.out.println("Enter updating passenger name");
				ps.setString(1, sc.next());
				ps.setInt(2, pid);
				n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Passenger name is updated successfully");
				}
				else{
					System.out.println("Passenger name is not able to update please try again");
				}
				break;
			case 4:
				ps=con.prepareStatement(Query.update_passenger_mobile);
				System.out.println("Enter updating passenger mobile number ");
				ps.setString(1, sc.next());
				ps.setInt(2, pid);
				n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Passenger mobile number is successfully updated");
				}else{
					System.out.println("Passenger mobile number is unable to update please try again");
				}
				break;
			case 5:
				ps=con.prepareStatement(Query.update_passenger_email);
				System.out.println("Enter updating passenger Email");
				ps.setString(1, sc.next());
				ps.setInt(2, pid);
				n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Passenger Email is successfully updated");
				}
				else{
					System.out.println("Passenger Email is not able updated please try again");
				}
				break;
				default:System.out.println("Please select choice range 1-5 only");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePassenger(int pid) {
		// TODO Auto-generated method stub
		try {
			ps=con.prepareStatement(Query.delete_passenger);
			System.out.println("Enter deleting passenger ");
			ps.setInt(1, pid);
			int n=ps.executeUpdate();
			if(n!=0){
				System.out.println("Passenger is successfully deleted");
			}else{
				System.out.println("not able to delete the passenger please try again");
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
