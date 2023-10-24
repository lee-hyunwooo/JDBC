package com.kh.MVC.orders;

import java.util.List;

public class OrdersController {
	private OrdersDAO dao;
	
	public OrdersController(OrdersDAO dao) {
		this.dao = dao;
	}
	
	public double calculateTotalPrice(List<OrdersDTO> orders) {
		double totalPrice = 0;
		for(OrdersDTO totalP : orders) {
			totalPrice += totalP.getTotal_price();
		}
		return totalPrice;
	}
	public List<OrdersDTO> getAllOrders() {
		return dao.getAllOrders();
	}
	
}
