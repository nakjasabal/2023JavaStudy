package ex14innerclass;

class A {
	void myFunc(){
		System.out.println("나는 A입니다.");
	}
}
class B extends A {
	@Override
	void myFunc() {
		System.out.println("나는 B처럼 살거야.");
	}	
}
public class Test {
	public static void main(String[] args) {
		A a = new A() {
			@Override
			void myFunc() {
				System.out.println("나는 익명클래스");
			}
		};
		a.myFunc();
	}
}








