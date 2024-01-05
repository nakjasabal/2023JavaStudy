package test;

class X {
	public X() {
		System.out.println("X의생성자");
	}
	public X(int a) {
		System.out.println("X의생성자");
	}
}
class Y extends X {
	public Y() {
		super(99);
		System.out.println("Y의생성자");
	}
}
public class Test4 {
	public static void main(String[] args) {
		Y y = new Y();
	}
}
