package ex16exception;

class MyErrorException extends Exception {
	public MyErrorException() {
		super("예외발생되씸");
	}
}
public class Test2 {
	
	public static void main(String[] args) {
		int a = 10;
		try {
			if(a != 10) {
				MyErrorException mex = new MyErrorException();
				throw mex;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
