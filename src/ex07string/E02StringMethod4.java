package ex07string;

public class E02StringMethod4 {

	public static void main(String[] args) {

		/*
		시나리오] 주민등록번호를 이용하여 성별을 판단하는
		프로그램을 charAt()을 이용해서 작성하시오.
		190419-3000000 => 남자
		190419-4000000 => 여자
		 */
		System.out.println("### 시나리오1 ###");
		String juminNum = "190419-8000000";
		System.out.println("7번째 인덱스의 문자="+ 
				juminNum.charAt(7));
		/* 주민번호로 주어진 문자열의 8번째 문자 즉 인덱스7에 해당하는
		문자가 성별을 표현하므로 이를 통해 판단한다. 추출했을때는 char형
		이므로 '(싱글쿼테이션)으로 비교해야한다. */
		char gender = juminNum.charAt(7);
		if(gender=='1' || gender=='3') {
			System.out.println("남자입니다.");
		}
		else if(gender=='2' || gender=='4')
			System.out.println("여자입니다.");
		else if(gender=='5' || gender=='6')
			System.out.println("외국인입니다.");
		else
			System.out.println("주민번호가 잘못되었습니다.");
	
		
		/*
		시나리오] 해당 문자열이 이메일 형식인지 검사하는
		프로그램을 contains()를 이용해서 작성하시오.
		hong@daum.net, aaaa@domain.co.kr => 이메일형식임
		not@naver => 이메일형식이아님
		*/
		System.out.println("### 시나리오2 ###");
		String email = "not@naver";
		/* 이메일은 아이디와 도메인을 @(엣)으로 구분한다. 또한 
		도메인에는 하나 이상의 .(닷)이 포함된다. 따라서 두가지 조건 
		모두 만족해야 하므로 논리And를 사용해서 판단한다. */
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일 형식이 맞습니다.");
		}
		else {
			System.out.println("이메일 형식이 아닙니다.");
		}
		
		/*
		시나리오3]주민등록번호로 성별을 구분하는 프로그램을 indexOf()와 
		charAt()을 이용해서 작성하시오.
		*/	
		System.out.println("### 시나리오3 ###");
		String jumin = "190419-3000000";
		/* 주민번호 문자열에서 하이픈의 위치를 찾는다. 성별은 그 다음에 
		있으므로 1을 더해 인덱스를 결정한다. */
		int index = jumin.indexOf("-") + 1;
		//앞에서 구한 인덱스를 charAt()의 인수로 전달한다. 
		if(jumin.charAt(index)=='1' || 
				jumin.charAt(index)=='3') {
			System.out.println("남자");
		}
		else if(jumin.charAt(index)=='2' || 
					jumin.charAt(index)=='4') {
			System.out.println("여자");
		} 
		 
		/*
		시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을
		작성하시오. 
		파일명 : my.file.images.jpg
		*/
		System.out.println("### 시나리오4 ###");
		System.out.println("방법1 - lastIndexOf() 사용");
		//파일명은 이와 같이 정의
		String filename = "my111.file222.images333.jpg";
		//문자열의 마지막에 있는 .(닷)의 위치를 찾은 후 1을 더해준다. 
		int indexNum = filename.lastIndexOf(".") + 1;
		//앞에서 구한 인덱스를 통해 확장자를 잘라낸다. 
		String fileExt = filename.substring(indexNum);
		System.out.println("파일확장자="+ fileExt);
		 
		System.out.println("방법2 - split() 사용");
		/* Java에서 split() 메서드 사용시 구분자로 .(닷)을 사용하는
		경우에는 []를 씌워줘야 한다. */
		String[] fileArr = filename.split("[.]");
		System.out.println("배열의크기="+ fileArr.length);
		System.out.println("파일확장자="+ 
				fileArr[fileArr.length-1]);
	}
}





