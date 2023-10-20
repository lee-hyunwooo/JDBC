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
	//보통 get 앞에는 리턴(int, String등)이 들어가야함
	//List<>는 다양한 값을 담을 수 있다
	public List<CafeDTO> getCafes() {
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				//기존에는 예약어나 참조어를 사용해서 넣어줄 값을 작성했지만
				//예를들어 int cafeId = result.getInt("cafe_id")
				//이제는 DTD를 활용하여 예약어나 참조어를 캡슐화(보호)하여 따로 DTO로 작성해준다.
				//그리고 DTO로 작성해준 객체를 인스턴스화하여 객체 안에 있는 멤버변수를 호출한다.
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_Number"));
				cafe.setOperatingHours(result.getString("operating_Hours"));//오라클에 저장되어 있는 이름 그대로 사용해야 하므로 _ 가 빠져도 에러 발생
				cafes.add(cafe);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cafes;
	}
	
}
