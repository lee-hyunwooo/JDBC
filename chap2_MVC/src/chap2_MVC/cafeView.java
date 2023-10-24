package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model =model;
	}

	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		//NAME, ADDRESS,PHONE_NUMBER,OPERATING_HOURS
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명 : ");
		
		String nmae = sc.nextLine();
		System.out.println("카페 주소 : ");
		String address = sc.nextLine();
		
		System.out.println("카페 연락처 : ");
		String phone_number = sc.nextLine();
		
		System.out.println("카페 운영 시간 : ");
		String operating_hours = sc.nextLine();
		
		//카페 모델에서 insertCafe 라는 메서드를 가지고 와야함
		model.insertCafe(nmae, address, phone_number, operating_hours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요.");
		//String description, int menuId, int cafeID
		
		System.out.println("카페 ID : ");
		int cafeID = sc.nextInt();
		
		System.out.println("메뉴 ID : ");
		int menuID = sc.nextInt();
		
		System.out.println("메뉴 설명 : ");
		String description = sc.nextLine();
		
		
		
		
	//모델에 있는 UpdateMenu를 가져와서 사용자가 작성한 수정 내용 추가하기
		model.UpdateMenu(description, menuID, cafeID);
		
		System.out.println("메뉴 설명이 업데이트 되었습니다.");
	}

	public void updatecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 업데이트 해주세요");
		//String operating_hours, int cafe_id
		System.out.println("변경하실 카페 ID를 입력해주세요.");
		int cafe_id = sc.nextInt();
		
		System.out.print("변경하실 운영시간을 입력해주세요.");
		String operationg_hours = sc.next();//next(), nextInt()는 버퍼가 존재함
											//println과 nextLine은 둘다 엔터기능이 존재하여 자동으로 넘어감
		
		sc.close();
		model.UpdateCafe(operationg_hours, cafe_id);
		System.out.println("카페 정보가 업데이트 되었습니다.");
	}
	
	public void deletecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제합니다.");
		System.out.println("삭제하실 카페 ID를 입력해주세요");
		int cafe_id = Integer.parseInt(sc.nextLine());
		//int cafe_id = sc.nextInt();
		sc.close();
		
		model.deleteCafe(cafe_id);
		System.out.println("카페가 삭제되었습니다.");
	}

	public void deletemenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제합니다.");
		System.out.println("삭제하실 메뉴 ID를 입력해주세요");
		int menu_id = Integer.parseInt(sc.nextLine());
		
		model.DeleteMenu(menu_id);
		System.out.println("메뉴 삭제가 완료되었습니다.");
	}
	
	public void deleteorder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주문정보를 삭제합니다");
		System.out.println("삭제하실 order_id를 입력해주세요.");
		int CAFE_id = Integer.parseInt(sc.nextLine());
		
		model.DeleteOrder(CAFE_id);
		System.out.println("주문이 삭제되었습니다.");
	}

}
