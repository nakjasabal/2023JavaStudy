package ex09package.study.area;

//원의 넓이를 계산하기 위한 클래스 
public class Circle {
	//멤버변수
	double rad;
	final double PI;
	//생성자
	public Circle(double rad){
		this.rad = rad;
		PI = 3.14159;
	}	
	//멤버메서드 : 원의 넓이 계산 후 반환
	public double getArea(){
		return PI * rad * rad;
	}	
}



