package ex17collection;

//오렌지를 표현한 클래스 
class Orange {
	//당도를 표현한 멤버변수와 메서드 정의 
	int sugar;
	public Orange(int sugar) {
		this.sugar=sugar;
	}	
	public void showInfo() {
		System.out.println("오렌지의 당도는 "+ sugar +" 입니다");
	}
}
//오렌지만 저장할 수 있는 전용박스 클래스 정의 
class OrangeBox{
	//Orange 타입의 인스턴스만 저장 및 반환하도록 정의 
	Orange item;
	//setter메서드 
	public void store(Orange item) { 
		this.item = item;
	}
	//getter메서드 
	public Orange pullOut() { 
		return item;
	}
}
//Object 기반으로 모든 과일(인스턴스)을 저장할 수 있는 상자 클래스 정의 
class FruitBox{
	//멤버변수, 생성자, getter, setter 
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}
public class Ex01GenericBasic {

	public static void main(String[] args) {
		
		/* 오렌지박스 인스턴스와 당도가 10인 오렌지 인스턴스를 생성한
		후 저장한다. */
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10); 
		oBox1.store(orange1);
		//getter를 통해 반환받은 후 정보를 출력한다. 
		orange1 = oBox1.pullOut();		
		orange1.showInfo();
		/* 
		상자1은 오렌지 전용박스이므로 다른 과일(즉 인스턴스)를 저장할 수
		없다. 컴파일 에러가 발생하게되므로 실행자체가 불가능해진다. 
		즉 자료형에는 안전하지만, 구현에는 불편함이 있다. 다른 인스턴스를
		저장하기 위해서는 또 다른 Box 클래스를 생성해야한다.  
		*/
				
		/*
		아래와 같이 Orange가 아닌 인스턴스를 저장하면 즉시 컴파일 
		에러가 발생하여 실행할 수 없는 코드가된다. 즉 자료형에는 
		안전하다고 할수있다.  
		*/
		//oBox1.store("당도가 20인 오렌지");
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
		
		/*
		Object 기반으로 생성된 FruitBox는 구현에는 편리하나 코드레벨에서
		에러가 발생하지 않으므로 오류를 찾아내기가 훨씬 더 어렵다. 
		 */
		//Orange 인스턴스를 저장 후 꺼낼때는 문제없이 실행되었다. 
		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();		
		
		/*
		하지만 오렌지 같은 String을 저장하고, 이를 꺼내서 다운캐스팅 하는
		부분에서는 예외가 발생된다. 즉 런타임 에러가 발생하게되므로 실행전
		에는 오류를 예측하기 쉽지않은 단점이 있다.  
		*/
		FruitBox fBox2 = new FruitBox("당도가 30인 오렌지");
		Orange orange4 = (Orange)fBox2.pullOut();//런타임에러발생
		orange4.showInfo();
	}
}


