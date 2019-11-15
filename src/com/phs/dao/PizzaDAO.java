package com.phs.dao;

import java.util.List;

import com.phs.bean.Pizza;

public interface PizzaDAO {
	
	public void addPizza();
	public Pizza viewPizza(int pid);
	public List<Pizza> viewAllPizza();
	public String updatePizza(int pid);
	public String deletePizza(int pid);
	public void cancel();
	public void bill(); 
	public void back();
	
	

}
