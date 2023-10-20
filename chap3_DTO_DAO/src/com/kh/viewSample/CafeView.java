package com.kh.viewSample;

import java.util.List;

import com.kh.dtoSample.CafeDTO;

public class CafeView {
	//view에는 주로 void 메서드를 사용한다.
	public void displayCafes(List<CafeDTO> cafes) {
		for(CafeDTO   c : cafes) {
			System.out.println("Cafe Id : " + c.getCafeId());
			System.out.println("Cafe Name : " + c.getCafeName());
			System.out.println("Cafe Address : " + c.getAddress());
			System.out.println("Cafe PhoneNumber : " + c.getPhoneNumber());
			System.out.println("Cafe OperatingHours : " + c.getOperatingHours());
			System.out.println("");
		}
	}
}
