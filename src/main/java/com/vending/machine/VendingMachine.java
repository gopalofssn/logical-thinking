package com.gs.cold.drinks.vending.machine;

import java.util.*;

public class VendingMachine {
	
	private VendingMachineState vendingMachineState;
	private ArrayList<Item> products = new ArrayList<Item>();
	
	private int cash = 0;
	 
	public VendingMachine() {
 
		products.add(new Item("COKE", 1, 1, 1));
		products.add(new Item("PEPSI", 2, 2, 1));
		
		setState(new ReadyState(this));
	}

	public void setState(VendingMachineState vendingMachineState) {
		this.vendingMachineState = vendingMachineState;		
	}
	
	public VendingMachineState getCurrentVendingMachineState() {
		return this.vendingMachineState;
	}

	public int getCash() {
		return cash;
	}

	public void addCash(int cash) {
		this.cash += cash;
	}

	public ArrayList<Item> getProducts() {
		return products;
	}

	public void setCash(int cash) {
		this.cash = cash;
		
	}
	
}
