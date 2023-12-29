package ex04controlstatement;

/*
if문 형식3
	if(조건1)
		조건1이 참일때;
	else if(조건2)
		조건2가 참일때;
	else
		위 모든 조건에 만족하지 않을때;
else문에는 조건식이 들어가면 에러가 발생하므로 주의해야한다. 	 
*/
public class E01If03 {

	public static void main(String[] args) {

		/*
		시나리오] 국,영,수 점수의 평균값을 구하여 학점을 출력하는
			프로그램을 작성하시오. 90점이상은 A학점...
			60점 미만은 F학점을 출력하면 된다. 
		 */
		//점수는 정수타입으로 할당한다. 
		int kor=99, eng=70, math=64;
		/* 평균값은 소수점이 나올수 있으므로 실수형으로 선언하는것이 좋다. 
		따라서 double의 결과를 얻기위해 3.0으로 나눠준다. */
		double avg = (kor+eng+math) / 3.0;
		System.out.println("평균점수는(그대로):"+ avg);
		System.out.printf("평균점수는(소수2자리):%.2f\n", 
				avg);
		
		//if~else문을 이용해서 2개이상의 조건을 사용할 수 있다. 
		if(avg>=90) {
			System.out.println("A학점");
		}
		else if(avg>=80) {
			System.out.println("B학점");
		}
		else if(avg>=70) {//평균이 77.67이므로 C학점 출력됨.
			System.out.println("C학점");
		}
		else if(avg>=60) {
			System.out.println("D학점");
		}
		else {
			System.out.println("F학점. 학사경고ㅜㅠ;");
		}
		
		System.out.println("잘못된 조건식의 if문");
		/* 앞에서 작성한 if문에서 조건의 순서만 변경되었지만, 60점 
		이상이라는 조건에 만족하기 때문에 높은 점수라도 모두 D학점이 
		출력된다. 문법적인 오류는 없으나 논리적 오류가 발생된 예이다. */
		if(avg>=60) {
			System.out.println("D학점");
		}
		else if(avg>=70) {
			System.out.println("C학점");
		}
		else if(avg>=80) {  
			System.out.println("B학점");
		}
		else if(avg>=90) {
			System.out.println("A학점");
		}
		else {
			System.out.println("F학점. 학사경고ㅜㅠ;");
		}
		
		
		
		
	}
}
