package ex10accessmodifier;

import ex10accessmodifier.cal.Calculator;
 
public class E04CalculatorMain {

	public static void main(String[] args) {
		
		/* 해당 클래스는 public으로 선언되었으므로 다른 패키지에서 
		import 후 사용할 수 있다. 하지만 Adder 클래스는 default로
		선언되었으므로 다른 패키지에서는 import가 불가능하다. 따라서 
		디폴트 클래스는 파일 내부에서 기능을 제공하는 정도로 사용할 
		목적으로 만들게된다. */
		Calculator cal = new Calculator();
				
		System.out.println("10+20="+ cal.addTwoNumber(10, 20));
		System.out.println("55+98="+ cal.addTwoNumber(55, 98));
		System.out.println("100-77="+ cal.subTwoNumber(100, 77));
		
		cal.showOpratingTimes();
	}
}

