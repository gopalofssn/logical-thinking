package com.gs.two.item.challenge;

public class Product {
	String name;
	float price;
	Product(String item, float price){
		this.name = item;
		this.price = price;
	}
	@Override
	public String toString() {
		return name + ", " + price;
	}
}
