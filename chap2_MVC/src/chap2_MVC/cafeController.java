package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view ;
	
	//�𵨰� �並 ������� ������
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	
	//run
	public void run() {
		Scanner sc = new Scanner(System.in);
		//������ ��ȣ ��� �޼���� �Է�
		System.out.println("1. ī�� ���� �߰�");
		System.out.println("2. �޴� ���� �߰�");
		System.out.println("3. ����");
		System.out.println("���ϴ� �۾��� �������ּ���.");
		
		boolean isTrue = true;
		while(isTrue) {
		int choice =sc.nextInt();
		
		switch (choice) {
		case 1:
			view.addCafeName();
			isTrue = false;
			break;
		case 2:
			view.updateMenu();
			isTrue = false;
			break;
		case 3:
			System.out.println("���α׷��� �����մϴ�");
			isTrue = false;
			break;
			
		default:
			System.out.println("�߸��� �����Դϴ�. �ٽ� �Է����ּ���");
			System.out.println("");
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴� ���� �߰�");
			System.out.println("3. ����");
			System.out.println("���ϴ� �۾��� �������ּ���.");
		}
		
		
		
		}
	}
	
	
}
