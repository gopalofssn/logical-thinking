package com.gs.cold.drinks.vending.machine;

import java.util.Scanner;

public class CashInState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public CashInState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		selectItem();
	}

	@Override
	public void cashIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub

	}


	@Override
	public void ready() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectItem() {
		Scanner sc = new Scanner(System.in);
		int cash = sc.nextInt();
		System.out.println("Available cash  " + cash );
		vendingMachine.addCash(cash);
		vendingMachine.setState(new SelectItem(vendingMachine));

	}

}
