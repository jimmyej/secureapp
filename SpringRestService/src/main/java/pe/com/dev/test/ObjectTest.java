package pe.com.dev.test;

public class ObjectTest {

	public static void main(String[] args) {
		int a = 7;
		int b=2;
		double c = a/b;
		System.out.println(c);
		
	}
	public double solveFunction(double a, double b, double c){
		double x = (-b + (Math.sqrt(b*b - 4+a+c)))/(2+a);
		return x;
	}

}
