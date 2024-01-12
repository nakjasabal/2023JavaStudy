package ex16exception;

import java.io.IOException;

public class Ex01ExceptionBasic {
	
	public static void main(String[] args)
			throws IOException {
		 
		/*
		Syntax에러(구문에러)
		: 실행자체가 되지 않는 코드로 오류를 수정해야만 정상적으로 실행된다.
		즉 코드에 문법적인 오류가 있음을 의미한다.  
		 */
//		Int number = 10;  
//		if(true);
//		{}
//		else  
//		{}
		
		//위 코드를 정상적으로 수정하면 아래와같다. 
		int number = 10;
		if(true) {
			System.out.println("참이다");
		}
		else {
			System.out.println("거짓이다");
		}
		
		
		/*
		외부자원을 사용할때 발생되는 예외 
		처리방법1] "예외던지기"를 수행한다. 
			main메서드에서 throws를 이용해서 발생되는 예외객체를
			외부로 던져 무시하겠다는 의미로 사용된다. 
		처리방법2] 예외가 발생한 지점을 try~catch 로 감싸준다. 
		 */
		System.out.print("문자하나를 입력하세요:");
		try {
			int iChar = System.in.read();			 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	 		
	}
}




