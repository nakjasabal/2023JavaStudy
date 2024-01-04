package ex09package;

//원의둘레를 계산하기위한 클래스는 import 한다. 
import ex09package.study.perimeter.Circle;

public class E02CircleMain {

	public static void main(String[] args) {
		/* 원의 넓이를 계산하기위한 클래스는 풀 패키지 경로를 이용해서
		인스턴스를 생성한다. */
		ex09package.study.area.Circle circle1 = 
				new ex09package.study.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의넓이:"
				+ circle1.getArea());
		
		/* 상단에서 import 했으므로 클래스명 만으로 인스턴스를 생성
		할 수 있다. */
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이 4.5인 원의둘레:"
				+ circle2.getPerimeter());		
	}
}


