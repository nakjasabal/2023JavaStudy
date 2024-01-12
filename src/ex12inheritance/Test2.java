package ex12inheritance;
//상속관계가 있는 클래스 정의
class X {
	void yourFunc() {
		System.out.println("나는 yourFunc(부모쪽에 정의)");
	}
}
class Y extends X {
	@Override
	void yourFunc() {
		System.out.println("나는 yourFunc(자식쪽에 정의)");
	}
}
public class Test2 {	
	public static void main(String[] args) {
		X x1 = new X();
		Y y1 = new Y();
		X x2 = new Y();
		
		myFunc();
		myFunc(99);
	}	
	//오버로딩의 예
	static void myFunc() {
		System.out.println("나는 myFunc()");
	}	
	static void myFunc(int p) {
		System.out.println("나는 오버로딩된 myFunc()");
	}
}