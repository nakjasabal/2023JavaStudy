package ex20io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Friend implements Serializable {
	//멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 저장한다. 
	String name;
	String phone;
	String addr;
	//생성자 : 멤버변수 초기화. 변수 구분을 위해 this 사용함. 
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버변수 전체를 출력하기 위한 멤버메서드 
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	public void showBasicInfo() {}
}
//고등학교 친구의 정보를 저장하기 위한 자식클래스 
class HighFriend extends Friend {
	//확장한 멤버변수 : 별명 
	String nickname; 
	//생성자 : 부모의 생성자를 먼저 호출한 후 멤버변수를 초기화한다.
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
	@Override
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번:"+ phone);
	}
}
//대학교 친구 정보를 저장하기 위한 자식클래스 
class UnivFriend extends Friend	{
	//확장한 멤버변수로 전공과목을 표현 
	String major;  
	//생성자 
	public UnivFriend(String name, String phone, String addr,
			String major) {
		super(name, phone, addr);
		this.major = major;
	}
	//오버라이딩1,2 역시 High클래스와 동일한 패턴으로 정의됨 
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
	}
}

//메인클래스 
public class E12MyFriendSerializable {

	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요 ########");
		System.out.print("1.고딩친구입력 ");
		System.out.println("2.대딩친구입력");
		System.out.print("3.전체정보출력 ");
		System.out.println("4.간략정보출력");
		System.out.print("5.검색 ");
		System.out.print("6.삭제 ");
		System.out.println("7.프로그램종료");
		System.out.print("메뉴선택>>>");
	}
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		/* 컬렉션은 최초 생성시 크기를 지정하지 않는다. 입력 혹은 삭제되는
		인스턴스에 따라 크기가 자동으로 설정된다. */
		FriendInfoHandler handler = 
				new FriendInfoHandler();
		
		/* 프로그램 시작시 직렬화된 파일이 있다면 즉시 복원하여 List
		컬렉션에 저장한다. */
		handler.readFriendInfo();

		while(true) {
			menuShow();
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllData();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				handler.searchInfo();
				break;
			case 6:
				handler.deleteInfo();
				break;
			case 7:
				/* 
				퀴즈] 프로그램을 종료할때 List컬렉션에 저장되었던 전체
				정보를 '직렬화'해서 파일에 저장한다. 
				파일명 : friend_info.obj 
				*/
				handler.saveFriendInfo();
				System.out.println("프로그램종료");
				return;
			}////switch 끝
		}////while 끝
	}////main 끝
}////class 끝

class FriendInfoHandler {
	//멤버변수 : [기존]인스턴스배열 => [변경]List컬렉션 
//	private Friend[] myFriends;
//	private int numOfFriends;
	
	/*
	기존에는 카운트를 위한 별도의 변수가 필요했지만, 컬렉션은 자동인덱싱을
	지원하므로 필요하지 않다. 즉, 컬렉션 인스턴스만 있으면된다. 
	*/
	ArrayList<Friend> lists;
	
	/*
	멤버변수가 변경되었으므로 생성자에서도 아래와 같이 수정해야한다. 
	컬렉션을 초기화 한다. 카운드가 필요없으므로 매개변수 num도 삭제한다.
	 */
	public FriendInfoHandler() {
//		myFriends = new Friend[num];	
//		numOfFriends = 0;
		lists = new ArrayList<Friend>();
	}
	
	//친구 연락처 정보 추가 
	public void addFriend(int choice) {
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
				
		if(choice==1) {
			//고딩 친구를 선택한 경우 별명을 추가로 입력받는다.
			System.out.print("별명:"); iNickname = scan.nextLine(); 
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
//			myFriends[numOfFriends++] = high;
			/* 기존 인스턴스배열에서는 인덱스를 위한 카운트가 필요했지만
			컬렉션에서는 필요하지 않다. 자동인덱싱이 지원되므로 add()를
			통해 추가하기만 하면 된다. */
			lists.add(high);
		}
		else if(choice==2) { 
			//대딩 친구인 경우 전공을 추가로 입력받는다. 
			System.out.print("전공:"); iMajor = scan.nextLine();
//			myFriends[numOfFriends++] = 
			lists.add(new UnivFriend(iName, iPhone, 
					iAddr, iMajor));
		} 
		System.out.println("친구정보 입력이 완료되었습니다.");
	}
	//전체정보를 출력하기 위한 메서드
	public void showAllData() {
//		for(int i=0 ; i<numOfFriends ; i++) {
//			myFriends[i].showAllData();
//		}
		//일반for문을 통해 반복 출력
		for(int i=0 ; i<lists.size() ; i++) {
			lists.get(i).showAllData();
		}
				
		System.out.println("==전체정보가 출력되었습니다==");
	}
	//간략정보를 출력하기 위한 메서드 
	public void showSimpleData() {
//		for(int i=0 ; i<numOfFriends ; i++) {
//			myFriends[i].showBasicInfo();
//		}
		//확장 for문으로 반복 출력 
		for(Friend fr : lists) {
			fr.showBasicInfo();
		}
		
		System.out.println("==간략정보가 출력되었습니다==");
	}
	
	//연락처 정보 검색
//	public void searchInfo() {
//		//검색 여부 확인위한 변수 
//		boolean isFind = false;		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("검색할 이름을 입력하세요:");
//		String searchName = scan.nextLine();		
//		
//		//이터레이터를 통해 검색 기능 구현 
//		Iterator<Friend> itr = lists.iterator();
//		//List 컬렉션 전체를 대상으로 반복
//		while(itr.hasNext()) {
//			Friend fr = itr.next();
//			//검색할 이름과 인스턴스에 저장된 이름이 같은지 확인 
//			if(searchName.equals(fr.name)) {
//				//일치하면 정보를 출력한다. 
//				fr.showAllData();
//				System.out.println("귀하가 요청하는 정보를 찾았습니다.");
//				isFind = true;
//			}
//		}
//		//초기값을 유지하고 있다면 정보는 없는 경우이다. 
//		if(isFind==false) 
//			System.out.println("찾는 정보가 없습니다."); 
//	}
	
	//연락처 정보 삭제
//	public void deleteInfo() {		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("삭제할 이름을 입력하세요:");
//		String deleteName = scan.nextLine();
//		
//		//인덱스는 음수가 없으므로 초기값은 -1로 지정한다. 
//		int deleteIndex = -1;
//		//확장for문으로 전체 반복 
//		for(Friend fr : lists) {
//			if(deleteName.compareTo(fr.name)==0) {
//				//정보가 일치하면 참조값을 통해 인스턴스 삭제 
//				lists.remove(fr);
//				//삭제가 완료되면 1로 변경
//				deleteIndex = 1;
//				//반복문을 즉시 탈출한다. 
//				break;
//			}
//		}
//		//삭제여부에 따라 메세지를 출력한다. 
//		if(deleteIndex==-1)
//			System.out.println("삭제된 데이터가 없습니다.");
//		else
//			System.out.println("데이터가 삭제되었습니다.");
//	}
	
	/*
	퀴즈1] 검색 기능의 메서드 searchInfo()를 일반 for문을 통해 
		기능을 구현하시오. 
	퀴즈2] 삭제 기능의 메서드 deleteInfo()를 이터레이터를 통해 
		기능을 구현하시오. 
	 */
	public void searchInfo() {	
		//검색한 이름이 있는지 확인용
		boolean isFind = false;		
		//스캐너 인스턴스 생성 
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();	
		
		//size()를 통해 컬렉션에 저장된 인스턴스의 갯수만큼 반복 
		for(int i=0 ; i<lists.size() ; i++) {
			/* i번째 인덱스의 인스턴스를 접근한 후 name을 얻어온다. 
			이를 통해 입력한 이름과 동일한지 확인한다. */
			//equals()를 통한 문자열 비교
//			if(searchName.equals(lists.get(i).name)) {
			//compareTo()를 통한 문자열 비교 
			if(searchName.compareTo(lists.get(i).name)==0) {
				//이름이 일치하면 정보를 출력한다. 
				lists.get(i).showAllData();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				//확인용 변수는 true로 변경 
				isFind = true;
			}
		}
		if(isFind==false) 
			System.out.println("**찾는 정보가 없습니다.**"); 
	}
	public void deleteInfo() {	
		//검색 확인용 변수
		boolean isFind = false;
		//스캐너 인스턴스 생성 
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		/*
		List컬렉션에 저장된 인스턴스를 기반으로 Iterator인스턴스를 
		생성한다. 이때 타입매개변수는 List와 동일하게 정의하면된다. 
		 */
		Iterator<Friend> itr = lists.iterator();
		//저장된 인스턴스의 갯수(컬렉션의 크기)만큼 반복한다. 
		while(itr.hasNext()) {
			//컬렉션에 저장된 참조값을 순서대로 인출한다. 
			Friend fr = itr.next();
			//인스턴스의 이름과 삭제할 이름을 비교한다. 
			if(deleteName.equals(fr.name)) {
				//일치하면 삭제한다. 
				lists.remove(fr);
				isFind = true;
				System.out.println("**귀하가 요청하는 정보를 삭제했습니다.**");
				//삭제에 성공했다면 즉시 반복문을 탈출한다. 
				break;
			}
		}
		if(isFind==false) 
			System.out.println("**찾는 정보가 없습니다.**"); 
	}
	
/*
현재 추가되는 정보는 List에 저장된다. 프로그램을 종료하면 저장된 내용이
소멸되므로, 재시작시 정보를 처음부터 다시 입력해야하는 불편함이 있다.
Serializable 인터페이스를 이용한 직렬화로 친구들의 정보를 파일로 저장해보자.   

연습문제1] 친구의 정보를 파일로 직렬화하기 위한 메서드를 정의하시오.
	-메서드명 : saveFriendInfo()
	-저장할 파일명 : myfriend_info.obj
	-메뉴 '7.프로그램종료'을 선택한 경우 실행하면 된다. 
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다. 

연습문제2] 프로그램을 다시 시작하면 문제1에서 직렬화 했던 파일을 
	역직렬화해서 복원하시오. 만약 3명의 정보가 저장되었다면 다시 
	시작한 직후 정보출력을 하면 3명의 정보가 출력되어야 한다. 
	메서드명 : readFriendInfo()
	※ 해당 메서드는 FriendInfoHandler 클래스에 추가하면 된다.
*/

	public void saveFriendInfo() {
		try {
			//직렬화(파일 저장)를 위한 출력스트림을 생성한다. 
			ObjectOutputStream out =
				new ObjectOutputStream(
					new FileOutputStream("src/ex20io/myfriend_info.obj")
				);
			
			//List 컬렉션에 저장된 친구의 정보의 갯수만큼 반복한다. 
			for(Friend fr : lists) {
				//파일에 인스턴스를 하나씩 저장한다. 
				out.writeObject(fr);
			}
			
			//스트림 소멸 
			out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void readFriendInfo() {
		ObjectInputStream in = null;
		try {
			//파일을 복원(역직렬화)하기 위해 스트림을 생성한다. 
			in = new ObjectInputStream(
					new FileInputStream("src/ex20io/myfriend_info.obj")
				);
			
			/*
			파일에 몇개의 정보가 저장되었는지 알수없으므로 무한루프로
			구성한다. 
			 */
			while(true) {
				/*
				직렬화될때 Object 타입으로 업캐스팅되어 저장되므로 
				역직렬화할때는 반드시 다운캐스팅 해야한다. 
				 */
				Friend fr = (Friend)in.readObject();
				//List 컬렉션에 정보를 추가한다. 
				lists.add(fr);
				/* 더 이상 복원한 정보가 없다면 EOF(End Of File)
				예외가 발생하여 while문을 탈출한 후 catch절로 
				이동한다. */
			}			
		}
		catch (FileNotFoundException e) {
			System.out.println("[예외]Obj파일이 없습니다.");
		}
		catch (EOFException e) {
			System.out.println("[예외]파일의 끝까지 모두 복원했습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("복원 중 알수없는 예외발생");
		}
		finally {
			/* try절에서 예외가 발생하더라도 finally절은 무조건 
			실행되므로 스트림은 정상적으로 닫을 수 있다. */
			try {
				in.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}














