package com.kh.MVC.orders;

import java.util.List;

public class OrdersView {
	public void showOrderList(List<OrdersDTO> orders) {
		for(OrdersDTO O : orders) {
			System.out.println("�ֹ���ȣ : " + O.getOrder_id());
			System.out.println("���� : " + O.getTotal_price());
			System.out.println("=====================");
		}
	}

	public void showTotalPrice(double totalPrice) {
		System.out.println("�� �� : " + totalPrice);
	}



}
