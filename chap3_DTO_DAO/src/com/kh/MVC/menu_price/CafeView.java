package com.kh.MVC.menu_price;

import java.util.List;

public class CafeView {
	public void showMenuList(List<CafeDTO> menus) {
		for(CafeDTO c : menus) {
			System.out.println("메뉴 이름 : " + c.getMenu_name());
			System.out.println("가격 : " + c.getPrice());
			System.out.println("===============");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}



}
