package ex06array;

public class E07ForEachObject {

	public static void main(String[] args) {
		
		//크기가 3인 인스턴스 배열을 생성한다. 
		String[] strArr = new String[] {
				"자바는 재미있다",
				"자바는 유용하다",
				"그러나 어렵다 ㅜㅜ"
		};
		
		//크기만큼 알아서 반복한다. 
		for(String e : strArr) {
			System.out.println(e);
		}
	}
}
