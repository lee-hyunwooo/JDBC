package com.kh.MVC.menu_price;

import java.util.List;

public class CafeMain {

	public static void main(String[] args) {
		CafeDAO dao = new CafeDAO();
		CafeController controller = new CafeController(dao);
		CafeView view = new CafeView();
		
		List<CafeDTO> menus = controller.getAllMenus();
		view.showMenuList(menus);
		
		double totalPrice = controller.calculateTotalPrice(menus);
		view.showTotalPrice(totalPrice);
		
	}

}
