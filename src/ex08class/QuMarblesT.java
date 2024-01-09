package ex08class;

class ChildPropertyT {	
	//멤버변수 : 어린이가 보유하고 있는 구슬의 갯수 
	int beads;	
	//생성자는 외부에서 호출해야 하므로 반드시 public으로 지정한다. 
	public ChildPropertyT(int beads) {
		this.beads = beads;
	}
	//반환값 없이 단순히 출력만 한다. 
	void showProperty() {
		System.out.println("보유 구슬의 개수:"+ this.beads);
	}
	
	void obtainBead(ChildPropertyT cp, int bCnt) {
		//승리한 어린이는 합산(호출의 주체가 되는 인스턴스)
		this.beads += bCnt;
		//패배한 어린이는 차감(매개변수로 전달된 인스턴스)
		cp.beads -= bCnt;
	}
}

public class QuMarblesT {

	public static void main(String[] args) {
		
		//생성자가 있는 클래스로 생성해야함. 
		ChildPropertyT child1 = new ChildPropertyT(20);
		ChildPropertyT child2 = new ChildPropertyT(15);
		 
		System.out.println("게임 전 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty(); 

		/*1차게임 : 어린이1은 어린이2의 구슬 5개 획득*/
		child1.obtainBead(child2, 5);

		/*2차게임 : 어린이2가 어린이1의 구슬 9개 획득*/
		child2.obtainBead(child1, 9);

		System.out.println("\n게임 후 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty();
	}

}
