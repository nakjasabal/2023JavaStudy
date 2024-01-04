package ex09package.study.perimeter;

//원의 둘레를 계산하기 위한 클래스 
public class Circle {
	//멤버변수
	double rad;
	final double PI;
	//생성자
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}	
	//원의 둘레를 계산한 후 반환한다. 
	public double getPerimeter(){	
		return 2 * PI * rad;
	}
}

