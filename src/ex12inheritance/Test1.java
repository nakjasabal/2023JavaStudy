package ex12inheritance;

class MyA {
	public MyA() {} //MyA클래스의 디폴트 생성자(생략가능) 
}
class MyB extends MyA {
	public MyB() {//MyB클래스의 디폴트 생성자(생략가능)
		super();//부모클래스인 MyA의 생성자를 호출하는 문장(생략가능)
	} 
}
public class Test1 {
	public static void main(String[] args) {
		/* 자식 클래스인 MyB를 통해서 인스턴스를 생성한다. 
		하지만 메모리상에는 부모의 인스턴스가 먼저 생성된 후 
		이를 토대로 자식의 인스턴스가 생성된다. 
		만약 자식쪽에서 부모생성자를 호출하지 못하게되면 에러가 
		발생한다.  
		*/
		MyB b = new MyB();
	}
}
