package ex08class;

//과일판매자를 추상화 한 클래스 
class FruitSeller2{
	int numOfApple;
	int myMoney;
	//기존에 상수로 선언했던 부분을 일반 변수로 변경한다. 
	int apple_price;
	/* 사과의 단가를 표현하는 멤버변수가 상수로 선언되면 선언과 동시에
	초기화해야한다. 또한 초기값이 없는 상태로 선언 자체가 불가능하다. 
	따라서 기존의 상수를 일반 변수로 변경해야한다. */
	
	/* 초기화 메서드를 선언하여 인스턴스 생성 후 다양한 형태의 초기화가
	가능하다. */	
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}	
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
//구매자를 추상화 한 클래스 
class FruitBuyer2{
	//멤버변수의 초기값이 없는 상태로 선언한다.
	int myMoney; 
	int numOfApple;
	
	//멤버변수의 초기화를 위한 멤버메서드를 생성한다. 
	public void initMembers(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E06FruitSalesMain2 {
	
	public static void main(String[] args) {
		
		/* 초기화 메서드를 정의하였으므로 상태가 다른 인스턴스를 생성할
		수 있다. */
		//판매자1 : 사과100개, 단가1,000원
		FruitSeller2 seller1 = new FruitSeller2();		
		seller1.initMembers(0, 100, 1000);
		//판매자2 : 사과:80개, 단가500원
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		//구매자 : 보유금액10,000원
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);

		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//각각의 판매자에게 5000원씩 지불하고 사과를 구매한다. 
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();//5개를 판매한다. 
		seller2.showSaleResult();//10개를 판매한다.
		//10,000원을 내고 15개를 구매한다. 
		buyer.showBuyResult();
	}
}



