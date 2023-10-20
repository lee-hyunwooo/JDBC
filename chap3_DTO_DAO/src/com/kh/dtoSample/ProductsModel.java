package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
	private Connection connection;
	
	public ProductsModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductsDTO> getProducts() {
		List<ProductsDTO> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				ProductsDTO product = new ProductsDTO();
				product.setProductId(result.getInt("product_Id"));
				product.setProductName(result.getString("Product_Name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStockQuantity(result.getInt("stock_Quantity"));
				products.add(product);
			
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	
}
