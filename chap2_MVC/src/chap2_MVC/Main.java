package chap2_MVC;

public class Main {

	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		
		//view.addCafeName();
		//view.updatecafe();
		//view.updateMenu();
		//view.deletecafe();
		//view.deletemenu();
		//view.deleteorder();
		
		//controller 
		cafeController controller = new cafeController(model, view);
		controller.run();
	}
}
