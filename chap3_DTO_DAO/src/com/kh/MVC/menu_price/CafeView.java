package com.kh.MVC.menu_price;

import java.util.List;

public class CafeView {
	public void showMenuList(List<CafeDTO> menus) {
		for(CafeDTO c : menus) {
			System.out.println("�޴� �̸� : " + c.getMenu_name());
			System.out.println("���� : " + c.getPrice());
			System.out.println("===============");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}



}
