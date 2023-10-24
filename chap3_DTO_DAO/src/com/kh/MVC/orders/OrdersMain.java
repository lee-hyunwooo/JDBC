package com.kh.MVC.orders;

import java.util.List;

public class OrdersMain {

	public static void main(String[] args) {
		OrdersDAO dao = new OrdersDAO();
		OrdersController controller = new OrdersController(dao);
		OrdersView view = new OrdersView();
		
		List<OrdersDTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);
		
	}

}
