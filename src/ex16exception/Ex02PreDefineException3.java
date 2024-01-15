package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02PreDefineException3 {
 
	public static void main(String[] args)  {	
 
		System.out.println("### InputMismatchException ###");
		Scanner sc = new Scanner(System.in);
		try {
			/* nextInt()를 통해 정수를 입력받아야 하지만, 실수로 
			문자를 잘못 입력하는 경우 발생하는 예외이다. */
			System.out.print("나이를 입력하세요:");
			int intAge = sc.nextInt(); 
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 앙데요");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}
	}////end of main 
}
