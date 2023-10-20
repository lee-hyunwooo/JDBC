package com.kh.ControllerSample;

import java.sql.Connection;
import java.util.List;

import com.kh.dtoSample.CafeDTO;
import com.kh.modelSample.CafeModel;
import com.kh.viewSample.CafeView;

//model�� view�� �������ִ� �߰� �ٸ�

public class CafeController {
	//�ʵ�
	private CafeModel model;  //�� �������
	private CafeView view;	  //�� �������
	
	//�Ķ���͸� �ۼ��� ������
	public CafeController(Connection con, CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;
	}
	
	//��¸޼���
	public void displayAllCafes() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}
