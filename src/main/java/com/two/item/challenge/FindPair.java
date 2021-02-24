package com.gs.two.item.challenge;

public class FindPair {

	private static void findPair(String[] args) {
		
		if(args == null || args.length != 2){
			StringBuilder sb = new StringBuilder();
			sb.append("Please input budget and file name in the below format")
			  .append("\n")
			  .append("FindPair 129.90 filename.txt");
			throw new IllegalArgumentException(sb.toString());
		}
		
		float budget = Float.parseFloat(args[0]);
		String fileName = args[1];
		Product[] products = FileToProductConverter.convert(fileName);
		findPairHelper(budget, products);
	}

	private static void findPairHelper(float budget, Product[] products) {
		int left = 0;
		int right = products.length - 1;
		int first = 0;
		int second = 0;
		float prevDiff = budget;
		while(left < right){
			float diff = budget - (products[left].price + products[right].price);
			if(diff < 0.0){
				right--;
			}else{
				if(diff < prevDiff){
					first = left;
					second = right;
					prevDiff = diff;
				}
				left++;
			}
		}
		printPair(new Product[]{products[first], products[second]});
	}

	private static void printPair(Product[] products) {
		if(products[0] == products[1]){
			System.out.println("No solution");
			return;
		}
		System.out.println(products[1]);
		System.out.println(products[0]);
	}

	public static void main(String[] args) {
		if(args != null && args.length != 0){
		    findPair(args);
		}else{
			System.out.println("************** 200.00, giftlist.txt ************");
			findPair(new String[]{"200.00","giftlist.txt"});
			System.out.println("************** 30.00, giftlist.txt ************");
			findPair(new String[]{"30.00","giftlist.txt"});
			System.out.println("************** 75.00, giftlist.txt ************");
			findPair(new String[]{"75.00","giftlist.txt"});
		}
	}
}
