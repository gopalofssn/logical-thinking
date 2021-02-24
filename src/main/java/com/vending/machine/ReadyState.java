package com.gs.cold.drinks.vending.machine;

public class ReadyState implements VendingMachineState {

	private VendingMachine vendingMachine;
	
	public ReadyState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
		ready();
	}
	
	@Override
	public void cashIn() {
		
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
		if(vendingMachine.getProducts().size() == 0){
			vendingMachine.setState(new OutOfOrderState(vendingMachine));
		}else {
			vendingMachine.setCash(0);
			System.out.println("VendingMachine is ready to serve you , please insert cash(enter number) ... \n");
			vendingMachine.setState(new CashInState(vendingMachine));
		}
		
	}

	@Override
	public void selectItem() {
		// TODO Auto-generated method stub
		
	}

}
