package com.gs.cold.drinks.vending.machine;

public class OutOfOrderState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public OutOfOrderState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		if(vendingMachine.getCash() > 0) {
			vendingMachine.setState(new RefundState(vendingMachine));
		}else {
		  System.out.println(" VendingMachine is  Out Of Order , please contact Admin at 1234 ");
		}
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
		// TODO Auto-generated method stub

	}

}
