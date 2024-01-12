package ex11static;

class AA {
	public AA() {
		//생성자 
	}
	void aFunc() {
		System.out.println("나는 A입니다.");
	}	
	static void bFunc() {
		System.out.println("나는 B입니다.");
	}
}
public class Test1 {
	public static void main(String[] args) {
		AA aa = new AA();
		aa.aFunc();
		
		AA.bFunc();
	}
}





