package com.gs.cold.drinks.vending.machine;

public class Item {
	private String name;
	private int price;
	private int itemId;
	private int total;

	public Item(String name, int price, int itemId, int total) {
		super();
		this.name = name;
		this.price = price;
		this.itemId = itemId;
		this.total = total;
	}

	 
	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}


	public int getItemId() {
		return itemId;
	}


	public int getTotal() {
		return total;
	}


	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", itemId=" + itemId + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}


	public void setTotal(int total) {
		this.total = total;		
	}

	
}
