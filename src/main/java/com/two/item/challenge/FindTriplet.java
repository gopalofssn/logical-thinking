package com.gs.two.item.challenge;

public class FindTriplet {
	
	private static void findTriplet(String[] args) {
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
		findTripletHelper(budget, products);	
	}
	
	private static void findTripletHelper(float budget, Product[] products) {
		
		int first = 0;
		int second = 0;
		int third = 0;
		float prevDiff = budget;
		for(int i = 0; i < products.length - 2; i ++){
			int left = i + 1;
			int right = products.length - 1;
			while(left < right){
				float diff = budget - (products[left].price + products[right].price);
				if(diff < 0.0){
					right--;
				}else{
					if(diff < prevDiff){
						first = i;
						second = left;
						third = right;
						prevDiff = diff;
					}
					left++;
				}
			}
		}
		printPair(new Product[]{products[first], products[second], products[third]});
	}

	private static void printPair(Product[] products) {
		if(products[0] == products[1]){
			System.out.println("No solution");
			return;
		}
		System.out.println(products[2]);
		System.out.println(products[1]);
		System.out.println(products[0]);
	}

	public static void main(String[] args) {
		if(args != null && args.length != 0){
			findTriplet(args);
		}else{
			System.out.println("************** 200.00, giftlist.txt ************");
			findTriplet(new String[]{"200.00","giftlist.txt"});
			System.out.println("************** 300.00, giftlist.txt ************");
			findTriplet(new String[]{"300.00","giftlist.txt"});
			System.out.println("************** 75.00, giftlist.txt ************");
			findTriplet(new String[]{"75.00","giftlist.txt"});
		}
	}



}
