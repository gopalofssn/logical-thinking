package com.gs.cold.drinks.vending.machine;

public class RefundState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public RefundState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		refund();
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
	public void selectItem() {
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
	   System.out.println("Refunded cash " + vendingMachine.getCash());
	   vendingMachine.setState(new ReadyState(vendingMachine));
	}

 

}
