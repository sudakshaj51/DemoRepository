package com.bms.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bms.bean.Bus;
import com.bms.bean.Reserve;
import com.bms.bean.Route;
import com.bms.dao.ReserveDao;
import com.bms.main.BusManagementSystem;
import com.bms.query.Query;
import com.bms.util.DBUtil;

public class ReserveDaoImpl implements ReserveDao {
	PreparedStatement ps = null;
	Connection con = DBUtil.getConnection();
	Reserve reserve = null;
	List<Reserve> reservations = null;
	Scanner sc = new Scanner(System.in);

	@Override
	public void addReserve() {
		int i = 1;
		while (i == 1) {
			try {
				ps = con.prepareStatement(Query.insert_reserve);
				System.out.println("Enter ticket id");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter seat");
				ps.setInt(2, sc.nextInt());
				ps.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
				System.out.println("Enter Passenger id");
				ps.setInt(4, sc.nextInt());
				System.out.println("Enter bus id");
				ps.setInt(5, sc.nextInt());
				ps.setDate(6, new java.sql.Date(2019 - 1900, 11, 14));
				ps.setString(7, "Active");
				int n = ps.executeUpdate();
				if (n != 0) {
					System.out.println("One Record inserted successfully");
				} else {
					System.out.println("unable to insert the record please try again");
				}
				System.out.println("Do you want to add more records press 1 else any number");
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
	public Reserve viewReserve(int tid) {
		Reserve reserve = new Reserve();
		try {
			ps = con.prepareStatement(Query.view_reservation);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reserve.setTid(rs.getInt(1));
				reserve.setSeat(rs.getInt(2));
				reserve.setTimestamp(rs.getTimestamp(3));
				reserve.setPid(rs.getInt(4));
				reserve.setBid(rs.getInt(5));
				reserve.setDate(rs.getDate(6));
				reserve.setStatus(rs.getString("status"));

			}
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

		return reserve;
	}

	@Override
	public List<Reserve> viewAllReservations() {
		reservations = new ArrayList<Reserve>();
		Reserve r1 = null;
		try {
			ps = con.prepareStatement(Query.view_all_reservations);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r1 = new Reserve();
				r1.setTid(rs.getInt(1));
				r1.setSeat(rs.getInt(2));
				r1.setTimestamp(rs.getTimestamp(3));
				r1.setPid(rs.getInt(4));
				r1.setBid(rs.getInt(5));
				r1.setDate(rs.getDate(6));
				r1.setStatus(rs.getString(7));
				r1.setStatus(rs.getString("status"));

				reservations.add(r1);
			}
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
		return reservations;
	}

	@Override
	public void updateReservation(int tid) {
		try {
			ps = con.prepareStatement(Query.update_reserve_seat);
			System.out.println("Enter updating seat");
			ps.setInt(1, sc.nextInt());
			ps.setInt(2, tid);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("Seat is updated");
			} else {
				System.out.println("unable to update the seat");
			}
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

	@Override
	public void deleteReservations(int tid) {
		try {
			ps = con.prepareStatement(Query.delete_reservation);
			System.out.println("Enter deleting ticket id");
			ps.setInt(1, tid);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("Reservation successfully deleted");
			} else {
				System.out.println("Not able delete the reservation Please try again");
			}
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

	@Override
	public void bill() {

		try {
			ps = con.prepareStatement("select r.pid,r.bid,r.tid,b.fare,r.seat,p.name from reserve r,bus b,passenger p where r.bid=b.bid and p.pid=r.pid");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getDouble(4) + "\t"+ rs.getInt(5)+ "\t" + rs.getString(6));
			}
			System.out.println("Select Your Bus Id ?");
			int bid = sc.nextInt();
			System.out.println("Enter Number of Seats ?");
			int nos = sc.nextInt();
			while (rs.previous()) {
			}
			while (rs.next()) {
				if (bid == rs.getInt(5)) {
					System.out.println("=================================");
					System.out.println("           YOUR TICKET           ");
					System.out.println("=================================");
					System.out.println("passenger id        " + rs.getInt(4));
					System.out.println("Bus id              " + rs.getInt(5));
					System.out.println("Ticket id           " + rs.getInt(1));
					System.out.println("No of Seats         " + nos);
					System.out.println("---------------------------------");
					System.out.println("Total Bill          " + (nos * rs.getDouble(4)));
					System.out.println("---------------------------------");

					PreparedStatement ps1 = con.prepareStatement("update reserve set seat=? where tid=?");
					int d = rs.getInt(5) - nos;
					ps1.setInt(1, d);
					ps1.setInt(2, rs.getInt(1));
					int result = ps1.executeUpdate();
					if (result != 0) {
						System.out.println("Happy Journey.Safe......");
					} else {
						System.out.println("Ticket not confirm. Please try again after sosme time");
					}

				}
				// System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * int a=0; int b=0;
		 * 
		 * 
		 * try { ps=con.prepareStatement(Query.bill); ps.setInt(1, tid);
		 * ResultSet rs=ps.executeQuery(); while(rs.next())
		 * 
		 * { System.out.println("Enter ");
		 * System.out.println("=================================");
		 * System.out.println("           YOUR TICKET           ");
		 * System.out.println("=================================");
		 * System.out.println("passenger id        "+rs.getInt(1));
		 * System.out.println("Bus id              " +rs.getInt(2));
		 * System.out.println("Ticket id           "+ rs.getInt(3));
		 * a=rs.getInt(4); b=rs.getInt(5);
		 * 
		 * System.out.println("price per ticket    "+ a);
		 * System.out.println("number of seats     " + b); } } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * System.out.println("=================================");
		 * System.out.println("Total bill      =   "+ a*b);
		 * System.out.println("================================="); ps =
		 * con.prepareStatement("update reserv set seat='"+)
		 */

	}

	@Override
	public void back() {
		BusManagementSystem.main(null);

	}

}
