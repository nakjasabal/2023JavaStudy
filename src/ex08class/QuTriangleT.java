package ex08class;

class TriangleT {
	//멤버변수
	int width;//밑변
	int height;//높이
	
	//초기화를 위한 메서드 	
	void init(int width, int height) {
		/* 멤버변수와 매개변수의 이름이 동일하면 구분하기 어려우므로
		this를 붙여서 구분하면된다. this는 자신의 멤버를 가리키는 
		키워드로 사용된다. */
		this.width = width;
		this.height = height;
	}
	
	double getArea() {
		return width * height * 0.5;
	}
	//밑변을 설정 
	void setBottom(int w) {
		this.width = w;
	}
	//높이를 설정 
	void setHeight(int h) {
		height = h;
	}
}

public class QuTriangleT {
	public static void main(String[] args)
	{
		TriangleT t = new TriangleT();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : "+ t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : "+ t.getArea());
	}
}




