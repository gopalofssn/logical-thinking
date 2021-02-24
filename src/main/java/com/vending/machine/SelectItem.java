package com.gs.cold.drinks.vending.machine;

import java.util.Scanner;

public class SelectItem implements VendingMachineState {

	private VendingMachine vendingMachine;

	public SelectItem(VendingMachine vendingMachine) {
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
	public void selectItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getItem() {
		System.out.println("Select Item \n" + vendingMachine.getProducts());
		Scanner sc = new Scanner(System.in);
		int itemNumber = sc.nextInt(); 
		Item item = vendingMachine.getProducts().get(itemNumber);
		System.out.println(item.getName() + " is selected");
		if(item.getPrice() > vendingMachine.getCash()) {
			System.out.println("Insuffcient cash .. ");
			vendingMachine.setState(new RefundState(vendingMachine));
		}
		vendingMachine.addCash(-1 * item.getPrice());
		int total = item.getTotal() -1;
		item.setTotal(total);
		if(total == 0) {
			vendingMachine.getProducts().remove(itemNumber);
		}
		vendingMachine.setState(new GetItemState(vendingMachine));
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
