package com.kh.dtoSample;

import java.util.List;

public class ProductsView {

	public void displayProducts(List<ProductsDTO> products) {
		for (ProductsDTO p : products) {
			System.out.println("Product Id : " + p.getProductId());
			System.out.println("Product Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("StockQuantity" + p.getStockQuantity());
			System.out.println("");
		}
	}
}
