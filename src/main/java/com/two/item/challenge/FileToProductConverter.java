package com.gs.two.item.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileToProductConverter {

	public static Product[] convert(String fileName){
		 Path path = Paths.get(fileName);
		 List<Product> productList = new ArrayList<>();
		  try(Stream<String> lines = Files.lines(path)){
			  Iterable<String> lineIterator = (Iterable<String>) lines::iterator;
			  for (String line : lineIterator){
			        String[] itemAndPrice = line.split("\\,");
			        float price = Float.parseFloat(itemAndPrice[1].trim());
			        productList.add(new Product(itemAndPrice[0],price));
			  }
		  } catch (IOException e) {
			  throw new IllegalArgumentException("Invalid file", e);
		}
		Product[] products = new Product[productList.size()];
		return productList.toArray(products);
	}
	
}
