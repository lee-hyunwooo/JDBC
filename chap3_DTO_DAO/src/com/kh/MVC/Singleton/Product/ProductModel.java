package com.kh.MVC.Singleton.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dtoSample.ProductDTO;

public class ProductModel {
/*
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
			//if �� selectOne, while�� selectAll
			while(result.next()) {
				ProductDTO product = new ProductDTO(); //�ν��Ͻ� ����
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
	
	*/
	private static Connection connection;
	//Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static ProductModel productmodel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	//�⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ°��� �����ϱ� ���� private���� ����
	private ProductModel() {
		
	}
	//ProductModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	//ó�� ȣ��� �� �����ͺ��̽��� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	//�̱��� ������ �����ϴ� ���
	public static ProductModel getInstance() throws SQLException {
		if(productmodel == null) {
			productmodel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productmodel;
	}
	
	public boolean insertProduct(ProductDTO product) {
		String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity"
						+"Values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStockQuantity());
		
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}



}
