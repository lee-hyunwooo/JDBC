package com.kh.modelSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.dtoSample.CafeDTO;

public class CafeModel {

	private Connection connection;
	
	public CafeModel(Connection connection) {
		this.connection = connection;
	}
	//���� get �տ��� ����(int, String��)�� ������
	//List<>�� �پ��� ���� ���� �� �ִ�
	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				//�������� ���� ����� ����ؼ� �־��� ���� �ۼ�������
				//������� int cafeId = result.getInt("cafe_id")
				//������ DTD�� Ȱ���Ͽ� ���� ����� ĸ��ȭ(��ȣ)�Ͽ� ���� DTO�� �ۼ����ش�.
				//�׸��� DTO�� �ۼ����� ��ü�� �ν��Ͻ�ȭ�Ͽ� ��ü �ȿ� �ִ� ��������� ȣ���Ѵ�.
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_Number"));
				cafe.setOperatingHours(result.getString("operating_Hours"));//����Ŭ�� ����Ǿ� �ִ� �̸� �״�� ����ؾ� �ϹǷ� _ �� ������ ���� �߻�
				cafes.add(cafe);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cafes;
	}
	
}
