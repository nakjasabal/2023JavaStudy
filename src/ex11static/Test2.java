package ex11static;

class MyClass {
	static void bFunc() {
		System.out.println("b가 호출됨");
	}
}
public class Test2 {	
	static void aFunc() {
		System.out.println("a가 호출됨");
	}	
	public static void main(String[] args) {		
		aFunc();
		
		MyClass mc = new MyClass();
		mc.bFunc();
		
		MyClass.bFunc();
	}
}


