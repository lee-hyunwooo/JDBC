package com.kh.modelSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dtoSample.ProductDTO;

public class ProductModel {
	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductDTO> getProducts() {
		List<ProductDTO> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			//if 는 selectOne, while은 selectAll
			while(result.next()) {
				ProductDTO product = new ProductDTO(); //인스턴스 생성
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
