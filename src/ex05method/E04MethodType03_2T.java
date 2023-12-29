package ex05method;

import java.util.Scanner;

/*
연습문제] 사용자로부터 2~9사이의 숫자중 2개를 입력받아 이에 해당하는 구구단을
출력하는 메서드를 작성하시오. 무조건 첫번째 입력받는 수가 작아야한다.
입력예]
	첫번째숫자 : 3
	두번째숫자 : 12
	3*1=3 3*2=6........
	........
	...................12*9=108
메서드명 : inputGugudan(int sNum, int eNum)
 */

public class E04MethodType03_2T {
	
	//while문으로 작성한 메서드 
	static void inputGugudan1(int sNum, int eNum){
		int dan = sNum; 
		while(dan<=eNum) { 
			int su = 1; 
			while(su<=9) {
				System.out.printf("%d*%d=%2d", dan, su, (dan*su));
				System.out.print(" ");
				su++;
			}
			System.out.println();
			//단을 1증가 시킴 
			dan++;
		}
	}
	
	//for문으로 작성한 메서드 
	static void inputGugudan2(int sNum, int eNum){
		//sNum단에서 eNum단 까지를 출력하는 프로그램 
		for(int dan=sNum ; dan<=eNum ; dan++) {
			for(int su=1 ; su<=9 ; su++) {
				System.out.print(dan +"*"+ su +"="+ (dan*su) +" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수 입력:");
		int s = scanner.nextInt();
		System.out.print("두번째 수 입력:");
		int e = scanner.nextInt();
		
		System.out.println("while문으로 작성한 구구단");		
		inputGugudan1(s, e);
		
		System.out.println("for문으로 작성한 구구단");
		inputGugudan2(s, e);
	}
}


