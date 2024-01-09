package ex12inheritance;

class Car {
    int gasoline;
    
    public Car(int gas) {
    	this.gasoline = gas;
    }
}
class HybridCar extends Car {
    int electric;
    
    //생성자 
    public HybridCar(int gas, int ele) {
    	super(gas);
    	this.electric = ele;
    }
}
class HybridWaterCar extends HybridCar {
   	int water;
   	
   	//생성자 
   	public HybridWaterCar(int gas, int ele, int wat) {
   		super(gas, ele);
   		this.water = wat;
   	}
 
   	public void showNowGauge()
   	{
      	System.out.println("남은가솔린:"+gasoline);
      	System.out.println("남은전기량:"+electric);
      	System.out.println("남은워터량:"+water);
   	}
}

public class QuConstructorAndSuperT {
	public static void main(String[] args)
	{
		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
		hcar.showNowGauge();
	}
}





