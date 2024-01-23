package ex17collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class A{
	String name;
	public A(String name) {
		this.name = name;
	}
}
class B extends A {
	int age;
	public B(String name, int age) {
		super(name);
		this.age = age;
	}
	@Override
	public int hashCode() {
		/* + this.age*/
		return super.name.hashCode(); 
	}	
	@Override
	public boolean equals(Object obj) {
		B aObj = (B) obj;
		/*aObj.age==this.age &&*/
		if(aObj.name.equals(super.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		
//		A[] aArr = new A[100];
//		int cnt=0;
//		aArr[cnt++] = new B();
//		aArr[cnt++] = new B();
		
//		List<A> aList = new ArrayList<A>();
		HashSet<A> aSet = new HashSet<A>();
		/*
		기준1 : 이름과 나이가 동일하면 동일한 객체로 판단 
		기준2 : 이름만 동일하면 동일한 객체로 판단(계좌관리와 동일)  
		 */
		boolean b1 = aSet.add(new B("홍길동", 10));
		System.out.println(b1);
		/*
		기준1 일때는 입력성공
		기준2 일때는 입력실패
		 */
		boolean b2 = aSet.add(new B("홍길동", 20));
		System.out.println(b2);
		
		/*
		기준2 일때는 홍길동10과 홍길동20은 동일한 인스턴스이므로
		아래와 같이 하면 홍길동10이 삭제된다. 
		 */
		aSet.remove(new B("홍길동", 20));
		/*
		홍길동20을 새롭게 입력한다. 따라서 덮어쓰기한 결과가 된다.
		 */
		aSet.add(new B("홍길동", 20));
		
		
		System.out.println(aSet.size());
	}
}




