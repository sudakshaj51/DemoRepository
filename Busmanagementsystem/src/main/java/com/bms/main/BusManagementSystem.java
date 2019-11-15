package com.bms.main;

import java.util.Scanner;

import com.bms.menus.AdminDetails;

public class BusManagementSystem {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("-----------------------------------");
			System.out.println("|    BUS MANAGEMENT SYSTEM        |");
			System.out.println("-----------------------------------");
			System.out.println("|   1. ADMIN                      |");
			System.out.println("|   2. PASSENGER                  |");
			System.out.println("|   3. ROUTE                      |");
			System.out.println("|   4. RESERVE                    |");
			System.out.println("|   5. EXIT                       |");
			System.out.println("-----------------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				AdminDetails.adminMenu();
				break;
			case 2:
				AdminDetails.passengerMenu();
				break;
			case 3:
				AdminDetails.routeMenu();
				break;
			case 4:
				AdminDetails.reserveMenu();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-3 only");
			}
		}


	}

}
