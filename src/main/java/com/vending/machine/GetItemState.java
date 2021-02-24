package com.gs.cold.drinks.vending.machine;

import java.util.Scanner;

public class GetItemState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public GetItemState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		getItem();
	}
	@Override
	public void ready() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cashIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectItem() {}

	@Override
	public void getItem() {
		
		System.out.println("Take your soda out !!! ");

		System.out.println("Remaining Balance " + vendingMachine.getCash());
		
		if(vendingMachine.getCash() <= 0){
			vendingMachine.setState(new ReadyState(vendingMachine));
		}else {
		  System.out.println("Press 1 for refund , any other number for select product !!! ");
		  Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();
			if(select == 1) {
		     vendingMachine.setState(new RefundState(vendingMachine));
			}else {
				vendingMachine.setState(new SelectItem(vendingMachine));
			}
		}

	

	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub

	}
 
}
