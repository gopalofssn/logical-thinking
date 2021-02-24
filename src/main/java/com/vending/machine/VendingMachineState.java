package com.gs.cold.drinks.vending.machine;

public interface VendingMachineState {
	public void ready();
	public void cashIn();
	public void selectItem();
	public void getItem();
	public void cancel();
	public void refund();
}
