package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model =model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		//NAME, ADDRESS,PHONE_NUMBER,OPERATING_HOURS
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ�� : ");
		
		String nmae = sc.nextLine();
		System.out.println("ī�� �ּ� : ");
		String address = sc.nextLine();
		
		System.out.println("ī�� ����ó : ");
		String phone_number = sc.nextLine();
		
		System.out.println("ī�� � �ð� : ");
		String operating_hours = sc.nextLine();
		
		//ī�� �𵨿��� insertCafe ��� �޼��带 ������ �;���
		model.insertCafe(nmae, address, phone_number, operating_hours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ �ϼ���.");
		//String description, int menuId, int cafeID
		
		System.out.println("ī�� ID : ");
		int cafeID = sc.nextInt();
		
		System.out.println("�޴� ID : ");
		int menuID = sc.nextInt();
		
		System.out.println("�޴� ���� : ");
		String description = sc.nextLine();
		
		
		
		
	//�𵨿� �ִ� UpdateMenu�� �����ͼ� ����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.UpdateMenu(description, menuID, cafeID);
		
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.");
	}

	public void updatecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ ������Ʈ ���ּ���");
		//String operating_hours, int cafe_id
		System.out.println("�����Ͻ� ī�� ID�� �Է����ּ���.");
		int cafe_id = sc.nextInt();
		
		System.out.print("�����Ͻ� ��ð��� �Է����ּ���.");
		String operationg_hours = sc.next();//next(), nextInt()�� ���۰� ������
											//println�� nextLine�� �Ѵ� ���ͱ���� �����Ͽ� �ڵ����� �Ѿ
		
		sc.close();
		model.UpdateCafe(operationg_hours, cafe_id);
		System.out.println("ī�� ������ ������Ʈ �Ǿ����ϴ�.");
	}
	
	public void deletecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����մϴ�.");
		System.out.println("�����Ͻ� ī�� ID�� �Է����ּ���");
		int cafe_id = Integer.parseInt(sc.nextLine());
		//int cafe_id = sc.nextInt();
		sc.close();
		
		model.deleteCafe(cafe_id);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}

	public void deletemenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����մϴ�.");
		System.out.println("�����Ͻ� �޴� ID�� �Է����ּ���");
		int menu_id = Integer.parseInt(sc.nextLine());
		
		model.DeleteMenu(menu_id);
		System.out.println("�޴� ������ �Ϸ�Ǿ����ϴ�.");
	}
	
	public void deleteorder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹ������� �����մϴ�");
		System.out.println("�����Ͻ� order_id�� �Է����ּ���.");
		int CAFE_id = Integer.parseInt(sc.nextLine());
		
		model.DeleteOrder(CAFE_id);
		System.out.println("�ֹ��� �����Ǿ����ϴ�.");
	}

}
