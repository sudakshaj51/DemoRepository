package com.bms.query;

public interface Query {
	public String insert_bus = "insert into Bus values(?,?,?,?,?,?,?)";
	public String view_bus = "select * from Bus where bid=bid and status='Active'";
	public String view_all_buses = "select * from Bus where status='Active'";
	public String update_bus_id ="update Bus set bid=? where bid=?";
	public String update_bus_type="update Bus set type=? where bid=?";
	public String delete_bus = "update Bus set status='Inactive' where bid=?";
	
	public String insert_passenger="insert into Passenger values(?,?,?,?,?,?,?)";
	public String view_passenger="select*from Passenger where pid=pid and status='Active'";
	public String view_all_passengers="select * from Passenger where status='Active'";
	public String update_passenger_id="update Passenger set pid=? where pid=?";
	public String update_passenger_username="update Passenger set username=? where pid=?";
	public String update_passenger_password="update Passenger set password=? where pid=?";
	public String update_passenger_name="update Passenger set name=? where pid=?";
	public String update_passenger_mobile="update Passenger set mobile=? where pid=?";
	public String update_passenger_email="update Passenger set email=? where pid=?";
	public String delete_passenger="update Passenger set status='Inactive' where pid=?";
	
	public String insert_reserve="insert into Reserve values(?,?,?,?,?,?,?)";
	public String view_reservation="select*from Reserve where tid=tid and status='Active'";
	public String view_all_reservations="select* from Reserve where status='Active'";
	public String update_reserve_seat="update Reserve set seat=? where tid=?";
	public String delete_reservation="update Reserve set status='Inactive' where tid=?";
	public String bill="select r.pid,r.bid,r.tid,b.fare,r.seat from reserve r,bus b where r.bid=b.bid  and r.tid=? ";
	
	public String insert_route="insert into Route values(?,?,?,?)";
	public String view_route="select*from Route where rid=rid and status='Active'";
	public String view_all_routes="select * from Route where status='Active'";
	public String update_from="update Route set fromplace=? where rid=?";
	public String update_to="update Route set toplace=? where rid=?";
	public String delete_route="update Route set status='Inactive' where rid=?";
}
