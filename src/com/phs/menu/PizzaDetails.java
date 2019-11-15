package com.phs.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.phs.bean.Pizza;
import com.phs.daoimpl.PizzaDAOImpl;

public class PizzaDetails {
	
	static Scanner sc=new Scanner(System.in);
	static PizzaDAOImpl pizzaDAO=new PizzaDAOImpl();
	
	public static void adminMenu() {
		System.out.println("-----------------------");
		System.out.println("      ADMIN MENU       ");
		System.out.println("-----------------------");
		System.out.println("    1.ADD PIZZA        ");
		System.out.println("    2.VIEW PIZZA       ");
		System.out.println("    3.VIEW ALL PIZZA   ");
		System.out.println("    4.UPDATE PIZZA     ");
		System.out.println("    5.DELETE PIZZA     ");
		System.out.println("    6.BACK             ");
		System.out.println("enter your choice ?");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
		         pizzaDAO.addPizza();
		         adminMenu();
		         break;
		case 2:
			System.out.println("enter your pizza id");
			Pizza pizza=pizzaDAO.viewPizza(sc.nextInt());
			System.out.println("Id"+"\t"+"Pizzaname"+"\t"+"type"+"\t"+"qty"+"price");
			System.out.println("--------------------------------------------------");
			System.out.println(pizza);
			adminMenu();
			break;
		case 3:
			List<Pizza> pizzas=pizzaDAO.viewAllPizza();
			System.out.println("Id"+"\t"+"Pizzaname"+"\t"+"type"+"\t"+"qty"+"price");
			System.out.println("--------------------------------------------------");
			for(Pizza p:pizzas) {
			System.out.println(p);}
			adminMenu();
			break;
		case 4:
        	System.out.println("Which pizza do you want to Update?");
        	String msg=pizzaDAO.updatePizza(sc.nextInt());
        	System.out.println(msg);
        	adminMenu();
        	break;
        case 5:
        	System.out.println("which pizza you want to delete?");
        	String ms=pizzaDAO.deletePizza(sc.nextInt());
        	adminMenu();
        	break;
        case 6:
        	pizzaDAO.back();
        	break;
        	default:
        		System.out.println("please select choice range 1-6 only");
        
		
			
		}
	}
		public static void customerMenu() {
			System.out.println("-----------------------");
			System.out.println("    CUSTOMER MENU      ");
			System.out.println("-----------------------");
			System.out.println("    1.VIEW PIZZA       ");
			System.out.println("    2.VIEW ALL PIZZA   ");
			System.out.println("    3.BILL             ");
			System.out.println("    4.BACK             ");
			System.out.println("enter your choice ?");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter your pizza id");
				Pizza pizza=pizzaDAO.viewPizza(sc.nextInt());
				System.out.println("Id"+"\t"+"Pizzaname"+"\t"+"type"+"\t"+"qty"+"price");
				System.out.println("--------------------------------------------------");
				System.out.println(pizza);
				customerMenu();
				break;
			case 2:
				List<Pizza> pizzas=pizzaDAO.viewAllPizza();
				System.out.println("Id"+"\t"+"Pizzaname"+"\t"+"type"+"\t"+"qty"+"price");
				System.out.println("--------------------------------------------------");
				for(Pizza p:pizzas) {
					System.out.println(p);}					
		customerMenu();
				break;
			case 3:
	        	pizzaDAO.bill();
	        	customerMenu();
				break;
	        case 4:
	        	pizzaDAO.back();
	        	break;
	        	default:
	        		System.out.println("please select choice range 1-6 only");
	        
			
				
			}

	}

}
