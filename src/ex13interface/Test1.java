package ex13interface;

abstract class Car {
	abstract void absFunc();
}
class SportCar extends Car {
	@Override
	void absFunc() {
	}
}
class SUV extends Car {	
	@Override
	void absFunc() {
	}
}
public class Test1 {
	public static void main(String[] args) {
		//Car car = new Car();
		SportCar sportCar = new SportCar();
		SUV suv = new SUV();
		
		Car arr[] = new Car[10];
		arr[0] = sportCar;
		arr[1] = suv;		
	}
}


