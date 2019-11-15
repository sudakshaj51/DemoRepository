package com.phs.main;

import java.util.Scanner;

import com.phs.menu.PizzaDetails;

public class PizzaManagement  {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("----------------------------");
		System.out.println("          PIZZA HOUSE       ");
		System.out.println("----------------------------");
		System.out.println("         1.AMIN             ");
		System.out.println("         2.CUSTOMER         ");
		System.out.println("         3.EXIT             ");
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			PizzaDetails.adminMenu();
			break;
		case 2:
			PizzaDetails.customerMenu();
			break;
		case 3:
			System.exit(0);
			break;
			default:
				System.out.println("enter only choice from 1-3 only ");
				
		}
		

	}

}
