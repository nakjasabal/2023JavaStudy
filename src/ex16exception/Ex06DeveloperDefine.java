package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
사용자정의 예외클래스
1.Exception 클래스를 상속한다. 
2.생성자에서 예외발생시 출력할 메세지를 super()를 통해 입력한다. 
3.예외 발생지점에서 if문으로 감지한 후 예외객체를 생성 및 throw한다.
4.catch절에서 예외객체를 잡아 처리한다. 
*/
class AgeErrorException extends Exception {
	public AgeErrorException() {
		super("나이 입력이 개잘못 되었어요");
	}
}

public class Ex06DeveloperDefine {

	public static void main(String[] args) {

		System.out.print("나이를 입력하세요 : ");
		try {
			/* 
			아래 메서드에서 예외가 발생할 수 있다는것을 알수있다. 
			또한 함수 호출문장이므로 해당 함수내에서 예외를 처리하지 않고
			throws 하므로 호출한 main에서 예외처리를 한다. 
			 */
			int age = readAge();
			System.out.println("당신의 나이는 "+ age +" 입니다.");
		}
		catch(AgeErrorException e) {
			System.out.println("[예외발생]"+ e.getMessage());
		}		
	}
	
	//"예외던지기(무시)"를 하여 호출한 지점으로 전달한다. 
	public static int readAge() throws AgeErrorException {
		Scanner sc = new Scanner(System.in);
		int inputAge=0;
		/* 나이 입력시 문자를 잘못 입력하는 경우에 대해 예외처리를 
		하고있다. 이 부분은 Java에서 미리 정의해놓은 예외처리 클래스를
		사용한다. */
		try {
			inputAge = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			/* 만약 첫번째 예외가 발생하면 즉시 프로그램이 종료된다. 
			필요없다면 아래 문장은 주석으로 처리하면된다. */
			System.exit(0);
		}
		
		/*
		만약 나이를 음수로 입력하는 경우에는 JVM이 예외를 감지하지 못하므로
		이때는 if문을 통해 판단해야한다. 그리고 개발자가 직접 정의한 
		예외클래스의 인스턴스를 생성한 후 throw한다. 
		 */
		if(inputAge<0) {
			/*
			예외객체를 throw하면 즉시 에러가 발생된다. 이를 반드시 
			catch해야되고, 그렇지 않으면 JVM에 의해 예외객체가 
			throw되는것과 동일하게 프로그램이 비정상 종료된다. 
			*/
			AgeErrorException ex = new AgeErrorException();
			throw ex;			
		}
		
		return inputAge;
	}
}




