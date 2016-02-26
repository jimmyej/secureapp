package pe.com.dev.util;

public class Ecuaciones {

	
	public void solveEcu(double a, double b, double c, double x1, double xn){
		
		//double y = a*x2+b*x+c;
		for (double x = x1; x <= xn; x++) {
			double y = a*x*x+b*x+c;
			System.out.println("( "+x+" , "+y+" )");
		}
		// 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Ecuaciones ecu = new Ecuaciones();
//		ecu.solveEcu(2, -3, 5, -5, 5);
		Ecuaciones ecu = new Ecuaciones();
		for (int i = 10; i > 0; i--) {
			System.out.println(ecu.drawTest(i));
		}
	}
	public String drawTest(int size){
		String strDraw = "";
		for (int i = 0; i < size; i++) {
			strDraw=strDraw+"*";
		}
		return strDraw;
	}

}
