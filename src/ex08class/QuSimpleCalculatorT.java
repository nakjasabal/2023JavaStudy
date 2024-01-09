package ex08class;

class CalculatorExT {
	//연산의 횟수를 카운트하기 위한 멤버변수 
	int addCnt;
	int minCnt;
	int mulCnt;
	int divCnt;
	
	//멤버변수를 0으로 초기화한다. 
	void initT() {
		addCnt = 0;
		minCnt = 0;
		mulCnt = 0;
		divCnt = 0;
	}
	//사칙연산을 위한 멤버메서드 
	double add(double n1, double n2) {
		//연산을 진행할때마다 1씩 카운트한다. 
		addCnt++;
		return n1 + n2;
	}
	double min(double n1, double n2) {
		minCnt++;
		return n1 - n2;
	}
	double mul(double n1, double n2) {
		mulCnt++;
		return n1 * n2;
	}
	double div(double n1, double n2) {
		divCnt++;
		return n1 / n2;
	}
	//연산의 횟수를 모두 출력한다. 
	void showOpCountT() {
		System.out.println("덧셈횟수 : "+ addCnt);
		System.out.println("뺄셈횟수 : "+ minCnt);
		System.out.println("곱셈횟수 : "+ mulCnt);
		System.out.println("나눗셈횟수 : "+ divCnt);
	}
}
public class QuSimpleCalculatorT {

	public static void main(String[] args)
	{
		CalculatorExT cal = new CalculatorExT();
		/* 함수 호출시 좌측항이 있거나 print문의 일부로 사용된다면
		반환값이 있는 형태로 정의해야 한다. 그렇지 않은 경우라면 반환값이
		없는 void로 정의하면된다. */
		cal.initT();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCountT();
	}


}
