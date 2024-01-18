package ex20io;

import java.io.BufferedReader;
import java.io.FileReader;

public class MailFormRead {

	public static void main(String[] args) {
		
		try { 
			BufferedReader in = new BufferedReader(
				new FileReader("src/ex20io/MailForm.html")
			);
			
			String str, html="";
			while(true) { 
				str = in.readLine(); 
				if(str==null) {
					break;
				}
				html += str;
			}
			in.close();
			
			//실무라면 DB에서 조건에 맞는 레코드를 인출해야한다.
			html = html.replace("__Name__", "홍길동");
			html = html.replace("__Addr__", "서울시 종로구 관철동");
			
			System.out.println(html);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
