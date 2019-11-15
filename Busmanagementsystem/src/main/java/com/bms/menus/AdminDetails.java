package com.bms.menus;

import java.util.List;
import java.util.Scanner;

import com.bms.bean.Bus;
import com.bms.bean.Passenger;
import com.bms.bean.Reserve;
import com.bms.bean.Route;
import com.bms.daoimpl.BusDaoImpl;
import com.bms.daoimpl.PassengerDaoImpl;
import com.bms.daoimpl.ReserveDaoImpl;
import com.bms.daoimpl.RouteDaoImpl;

public class AdminDetails {
	static Scanner sc = new Scanner(System.in);
	static BusDaoImpl BusDao = new BusDaoImpl();
	static RouteDaoImpl RouteDao=new RouteDaoImpl();
	static PassengerDaoImpl PassengerDao=new PassengerDaoImpl();
	static ReserveDaoImpl ReserveDao=new ReserveDaoImpl(); 

	public static void adminMenu() {
		System.out.println("----------------------------");
		System.out.println("|     BUS MAIN MENU      |");
		System.out.println("----------------------------");
		System.out.println("|  1. ADD BUS              |");
		System.out.println("|  2. VIEW BUS             |");
		System.out.println("|  3. VIEW ALL BUSES       |");
		System.out.println("|  4. UPDATE BUS           |");
		System.out.println("|  5. DELETE BUS           |");
		System.out.println("|  6. BACK                 |");
		System.out.println("----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			BusDao.addBus();
			adminMenu();
			break;
		case 2:
			System.out.println("Enter Search Bus Id ?");
			Bus bus = BusDao.viewBus(sc.nextInt());
			System.out.println("BID" + "\t" + "TYPE" + "\t" + "FARE"+"\t"+"DEPTTIME"+"\t"+"ARRVTIME"+"\t"+"RID"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			System.out.println(bus);
			adminMenu();
			break;
		case 3:
			List<Bus> buses = BusDao.viewAllBuses();
			System.out.println("BID" + "\t" + "TYPE" + "\t" + "FARE"+"\t"+"DEPTTIME"+"\t"+"ARRVTIME"+"\t"+"RID"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			for (Bus b : buses) {
				System.out.println(b);
			}
			adminMenu();
			break;
		case 4:
			System.out.println("Which Bus do you want to Update ?");
			BusDao.updateBus(sc.nextInt());
			adminMenu();
			break;
		case 5:
			System.out.println("Which Bus do you want to Delete ?");
			BusDao.deleteBus(sc.nextInt());
			adminMenu();
			break;
		case 6:
			BusDao.back();
			break;
		default:
			System.out.println("Please select choice range 1-6 only");
		}

		} 
	public static void passengerMenu(){
		System.out.println("----------------------------");
		System.out.println("|     PASSENGER MAIN MENU  |");
		System.out.println("----------------------------");
		System.out.println("|  1. ADD PASSENGER        |");
		System.out.println("|  2. VIEW PASSENGER       |");
		System.out.println("|  3. VIEW ALL PASSENGERS  |");
		System.out.println("|  4. UPDATE PASSENGER     |");
		System.out.println("|  5. DELETE PASSENGER     |");
		System.out.println("|  6. BACK                 |");
		System.out.println("----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			PassengerDao.addPassenger();
			passengerMenu();
			break;
		case 2:
			System.out.println("Enter Search Passenger Id ?");
			Passenger passenger = PassengerDao.viewPassenger(sc.nextInt());
			System.out.println("PID" + "\t" + "USERNAME" + "\t" + "PASSWORD"+"\t"+"NAME"+"\t"+"MOBILE"+"\t"+"EMAIL"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			System.out.println(passenger);
			passengerMenu();
			break;
		case 3:
			List<Passenger> passengers = PassengerDao.viewAllPassengers();
			System.out.println("PID" + "\t" + "USERNAME" + "\t" + "PASSWORD"+"\t"+"NAME"+"\t"+"MOBILE"+"\t"+"EMAIL"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			for (Passenger p : passengers) {
				System.out.println(p);
			}
			passengerMenu();
			break;
		case 4:
			System.out.println("Which Passenger do you want to Update ?");
			PassengerDao.updatePassenger(sc.nextInt());
			passengerMenu();
			break;
		case 5:
			System.out.println("Which Passenger do you want to Delete ?");
			PassengerDao.deletePassenger(sc.nextInt());
			passengerMenu();
			break;
		case 6:
			PassengerDao.back();
			break;
		default:
			System.out.println("Please select choice range 1-6 only");
		}

	}
	public static void reserveMenu(){
		System.out.println("----------------------------");
		System.out.println("|    RESERVATION MAIN MENU |");
		System.out.println("----------------------------");
		System.out.println("|  1. ADD RESERVATION      |");
		System.out.println("|  2. VIEW RESERVATION     |");
		System.out.println("|  3. VIEW ALL RESERVATIONS|");
		System.out.println("|  4. UPDATE RESERVATION   |");
		System.out.println("|  5. DELETE RESERVATION   |");
		System.out.println("|  6. BILL                 |");
		System.out.println("|  7. BACK                 |");
		System.out.println("----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			ReserveDao.addReserve();
			reserveMenu();
			break;
		case 2:
			System.out.println("Enter Search Reservation Id ?");
			Reserve reserve = ReserveDao.viewReserve(sc.nextInt());
			System.out.println("TID" + "\t" + "SEAT" + "\t" + "TIMESTAMP"+"\t"+"PID"+"\t"+"BID"+"\t"+"DATE"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			System.out.println(reserve);
			reserveMenu();
			break;
		case 3:
			List<Reserve> reservations = ReserveDao.viewAllReservations();
			System.out.println("TID" + "\t" + "SEAT" + "\t" + "TIMESTAMP"+"\t"+"PID"+"\t"+"BID"+"\t"+"DATE"+"\t"+"STATUS");
			System.out.println("-----------------------------");
			for (Reserve r : reservations) {
				System.out.println(r);
			}
			reserveMenu();
			break;
		case 4:
			System.out.println("Which Reservation do you want to Update ?");
			ReserveDao.updateReservation(sc.nextInt());
			reserveMenu();
			break;
		case 5:
			System.out.println("Which Reservation do you want to Delete ?");
			ReserveDao.deleteReservations(sc.nextInt());
			reserveMenu();
			break;
		case 6:
			ReserveDao.bill();
			reserveMenu();
			break;
		case 7:
			ReserveDao.back(); 
			break;
		default:
			System.out.println("Please select choice range 1-7 only");
		}
	}
		public static void routeMenu(){
			System.out.println("----------------------------");
			System.out.println("|    ROUTE MAIN MENU       |");
			System.out.println("----------------------------");
			System.out.println("|  1. ADD ROUTE            |");
			System.out.println("|  2. VIEW ROUTE           |");
			System.out.println("|  3. VIEW ALL ROUTES      |");
			System.out.println("|  4. UPDATE ROUTE         |");
			System.out.println("|  5. DELETE ROUTE         |");
			System.out.println("|  6. BACK                 |");
			System.out.println("----------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
			    RouteDao.addRoute();
				routeMenu();
				break;
			case 2:
				System.out.println("Enter Search Route Id ?");
				Route route = RouteDao.viewRoute(sc.nextInt());
				System.out.println("RID" + "\t" + "FROM" + "\t" + "TO"+"\t"+"STATUS");
				System.out.println("-----------------------------");
				System.out.println(route);
				routeMenu();
				break;
			case 3:
				List<Route> routes = RouteDao.viewAllRoutes();
				System.out.println("RID" + "\t" + "FROM" + "\t" + "TO"+"\t"+"STATUS");
				System.out.println("-----------------------------");
				for (Route r1 : routes) {
					System.out.println(r1);
				}
				routeMenu();
				break;
			case 4:
				System.out.println("Which Route do you want to Update ?");
				RouteDao.updateRoute(sc.nextInt());
				routeMenu();
				break;
			case 5:
				System.out.println("Which Route do you want to Delete ?");
				RouteDao.deleteRoute(sc.nextInt());
				routeMenu();
				break;
			case 6:
				RouteDao.back();
				break;
			default:
				System.out.println("Please select choice range 1-6 only");
			}
		}

	}
	