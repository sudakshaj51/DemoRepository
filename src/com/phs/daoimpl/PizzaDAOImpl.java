package com.phs.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.phs.bean.Pizza;
import com.phs.dao.PizzaDAO;
import com.phs.main.PizzaManagement;

public class PizzaDAOImpl implements PizzaDAO {
	Scanner sc=new Scanner(System.in);
	static List<Pizza> pizzas=new ArrayList<Pizza>();
	static List<Pizza> temp=new ArrayList<Pizza>();
	Pizza pizza=null;
	
	

	@Override
	public void addPizza() {

		int i=1;
		while(i==1) {
			System.out.println("enter pizza id");
			int pid=sc.nextInt();
			System.out.println("enter pizza name");
			String pname=sc.next();
			System.out.println("enter pizza type");
			String type=sc.next();
			System.out.println("enter pizza quantity");
			int qty=sc.nextInt();
		    System.out.println("enter pizza price");
		    double price=sc.nextDouble();
		    pizza=new Pizza(pid,pname,type,qty,price);
		    System.out.println("enter 1 to add more pizzas or select other key");
		    i=sc.nextInt();
		    
		}
		System.out.println("Pizza is added");
	}

	@Override
	public Pizza viewPizza(int pid) {

		Pizza pizza=new Pizza();
		for(Pizza p:pizzas) {
			if(p.getPid()==pid) {
				pizza=p;
			}
		}
		
		return pizza;
	}

	@Override
	public List<Pizza> viewAllPizza() {
		// TODO Auto-generated method stub
		return pizzas;
	}

	@Override
	public String updatePizza(int pid) {
		String msg;
		for(Pizza p:pizzas) {
			if(p.getPid()==pid) {
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
				System.out.println("enter updated pizza name");
				String pname=sc.next();
				break;
				case 2:
				System.out.println("enter updated pizza type");
				String type=sc.next();
				break;
				case 4:
				System.out.println("enter updated pizza quantity");
				int qty=sc.nextInt();
				break;
				case 5:
				System.out.println("enter updated pizza price");
				double price=sc.nextDouble();
				break;
				default:
					System.out.println("enter only 1-5 choices only");
			}
				temp.add(p);		
	}else {
		temp.add(p);	
		}
		}
			pizzas= new ArrayList<Pizza>();
			for(Pizza p1:temp) {
			     pizzas.add(p1);
			}
			
			if(pizzas!=null) {
				msg= "updated sucessfully";
			}else {
				msg="not updated";
			}
	
		return msg;
	
		}
	@Override
	public String deletePizza(int pid) {
		temp=new ArrayList<Pizza>();
		String msg;
		for(Pizza p:pizzas) {
		if(p.getPid()==pid) {
			
		}else {
			temp.add(p);
		}
		}
		
		pizzas=new ArrayList<Pizza>();
		for(Pizza p1:temp) {
			pizzas.add(p1);
		}
		if(pizzas!=null) {
			msg="deleted sucessfully";
		}else {
			msg="not deleted";
		}
		
		return msg;
	}

	@Override
	public void bill() {
		Pizza pizza=new Pizza();
		temp= new ArrayList<Pizza>();
		for(Pizza p:pizzas) {
			System.out.println(p);
		}
		System.out.println("enter pizza id");
		pizza.setPid(sc.nextInt());
		System.out.println("enter pizza qty");
		pizza.setQty(sc.nextInt());
        for(Pizza p:pizzas) {
        	if(p.getPid()==pizza.getPid()) {
        		System.out.println("--------------------------");
        		System.out.println("           BILL           ");
        		System.out.println("pizza id: "+p.getPid());
        		System.out.println("pizza name: "+p.getPname());
        		System.out.println("pizza type: "+p.getType());
        		System.out.println("pizza quantity: "+p.getQty());
        		System.out.println("pizza price: "+p.getPrice());
        		System.out.println("total amount: "+p.getQty()*p.getPrice());
        		temp.add(p);
        		
        		
        	}else {
        		temp.add(p);
        	}
        }
		
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		PizzaManagement.main(null);
		
	}

	@Override
	public void cancel() {

		
	}

	

}
