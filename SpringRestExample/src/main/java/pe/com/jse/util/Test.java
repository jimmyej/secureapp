package pe.com.jse.util;

import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.getMessage();
	}
	public void getMessage(){
		String message1 = this.getClass().getName();
		System.out.println(message1);
		
		String message2 = this.getClass().getSimpleName();
		System.out.println(message2);
		
		String message3 = this.getClass().getCanonicalName();
		System.out.println(message3);
		
		Method meth[] = this.getClass().getDeclaredMethods();
		System.out.println(meth[1].getName());
		
		Method lastMethodCalled = this.getClass().getEnclosingMethod();
		System.out.println(lastMethodCalled);

	}

}
