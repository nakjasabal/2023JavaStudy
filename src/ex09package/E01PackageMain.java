/*
패키지 선언부 : 현재 작성하는 클래스의 위치를 결정하기 위한 선언으로
	해당 클래스를 특정 패키지 하위에 묶어서 생성한다는 의미이다. 
 */
package ex09package;

/*
임포트 선언부 : 현재 작성중인 클래스에 다른 패키지에 선언된 클래스를 
	가져다 쓰기위한 선언으로, 사용할 클래스의 위치를 지정하는 것으로
	생각하면된다. 
 */
import java.util.Date;

import ex09package.study.util.CommonUtil;

/*
클래스 선언부 : 우리가 구현할 내용을 작성한다. 
*/
public class E01PackageMain {

	public static void main(String[] args) {		  	
		 
		/*
		하나의 클래스안에 패키지는 다르나 같은 이름의 클래스를 사용해야
		한다면..
		방법1 : 클래스명 앞에 풀 패키지 경로를 기술한다. 
		방법2 : 하나의 클래스는 import하고, 다른 하나는 풀 패키지
			경로를 기술한다. 
		 */
		//상단에 import한 클래스를 통해 인스턴스 생성 
		Date utilDate = new Date(); 
		System.out.println("utilDate="+ utilDate);
	
		//패키지의 풀경로를 이용해서 인스턴스 생성 
		java.sql.Date sqlDate = 
				new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate="+ sqlDate);

		/* 개발자가 직접 정의한 클래스도 패키지가 다른 경우에는 상단에
		import 선언 후 사용해야 한다. */
		String strValue = "987654321";
		
		/*
		static으로 선언된 메서드는 new를 통해 인스턴스 생성없이
		클래스명으로 직접 메서드를 호출할 수 있다. 
		Java에서 제공하는 클래스 중 대표적으로 Math를 예로 들수있다. 
		난수생성을 위해 별도의 인스턴스 생성없이 Math.random()을 
		호출하여 난수를 생성한다. 
		 */
		boolean isNum = CommonUtil.isNumber(strValue);		
		if(isNum==true)
			System.out.println("문자열은 숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
		
		/* 메서드 호출시 패키지명까지 모두 입력한 상태로 사용하는 것도
		가능하다. */
		System.out.println(
			ex09package.study.util.CommonUtil
				.isNumber("백20"));	
	}
}





