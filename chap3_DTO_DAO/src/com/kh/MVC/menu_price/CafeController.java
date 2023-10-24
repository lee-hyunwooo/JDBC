package com.kh.MVC.menu_price;

import java.util.List;

public class CafeController {
	private CafeDAO dao;
	
	public CafeController(CafeDAO dao) {
		this.dao = dao;
	}
	
	public double calculateTotalPrice(List<CafeDTO> menus) {
		double totalPrice = 0;
		for(CafeDTO totalP : menus) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	public List<CafeDTO> getAllMenus() {
		return dao.getAllMenus();
	}
	
}
