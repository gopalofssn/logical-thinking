package com.gs.two.item.challenge;

import java.util.ArrayList;
import java.util.List;

public class FindKGiftItem {
    private static float prevDiff;
	private static List<Product> selectedGifts = new ArrayList<>();
	
	private static void findKGiftItem(String[] args) {
		if(args == null || args.length != 3){
			StringBuilder sb = new StringBuilder();
			sb.append("Please input budget and file name in the below format")
			  .append("\n")
			  .append("FindPair 700.00 filename.txt 4");
			throw new IllegalArgumentException(sb.toString());
		}
		float budget = Float.parseFloat(args[0]);
		String fileName = args[1];
		Product[] products = FileToProductConverter.convert(fileName);
		int k = Integer.parseInt(args[2]);
		prevDiff = budget;
		findKGiftItemHelper(products, 0, budget, k, new ArrayList<>());
		printKGift();
	}

	private static void findKGiftItemHelper(Product[] products, int index, float budget, final int k, List<Product> result) {
		if(budget < 0.0 || index >= products.length) {
			return;
		}else if(result.size() == k){
			if(budget < prevDiff){
				selectedGifts = new ArrayList<>(result);
				prevDiff = budget;
			}
		}else{
			findKGiftItemHelper(products, index + 1, budget, k, new ArrayList<>(result));
			List<Product> newResult =  new ArrayList<>(result);
			newResult.add(products[index]);
			findKGiftItemHelper(products, index + 1, (budget - products[index].price), k, newResult);
		}
		
	}	

	private static void printKGift() {
		if(selectedGifts.size() == 0){
			System.out.println("No solution");
			return;
		}
		
		for(Product product : selectedGifts){
			System.out.println(product);
		}
	}

	public static void main(String[] args) {
		if(args != null && args.length != 0){
			findKGiftItem(args);
		}else{
			System.out.println("************** 200.00, giftlist.txt ************");
			findKGiftItem(new String[]{"100.00","giftlist.txt", "4"});
			System.out.println("************** 300.00, giftlist.txt ************");
			findKGiftItem(new String[]{"300.00","giftlist.txt", "4"});
			System.out.println("************** 540.00, giftlist.txt ************");
			findKGiftItem(new String[]{"540.00","giftlist.txt", "4"});
			System.out.println("************** 550.00, giftlist.txt ************");
			findKGiftItem(new String[]{"550.00","giftlist.txt", "4"});
		}
	}
}
