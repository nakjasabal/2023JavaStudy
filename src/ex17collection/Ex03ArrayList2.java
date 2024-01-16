package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import common.Student;

public class Ex03ArrayList2 {

	public static void main(String[] args) {
		
		/*
		아래 2개의 컬렉션은 내부적인 자료구조만 다를뿐 구현방법에는 
		차이가 없다. 인스턴스 생성시 Student 타입매개변수를 통해 
		생성한다. 즉, Student 인스턴스를 저장할 수 있는 상자가된다. 
		 */
		LinkedList<Student> list2 = new LinkedList<Student>();
		//ArrayList<Student> list2 = new ArrayList<Student>();
		 
		/*
		저장할 Student 인스턴스 생성. 외부패키지에 선언되었으므로 반드시
		import 후 사용해야한다. 
		 */
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		 
		//컬렉션에 인스턴스 추가. 인덱스는 자동으로 부여된다. 
		list2.add(st1); //인덱스 0
		list2.add(st2);
		list2.add(st3);
		list2.add(st4); //인덱스 3
		//List는 중복저장이 가능하므로 정상적으로 추가된다. 
		list2.add(st2); 
		
		/*
		일반 for문 사용을 위해 size()로 추가된 인스턴스의 갯수를 반환
		받는다. 또한 index로 접근해야 하므로 get()을 사용한다. 
		현재 총 5개의 인스턴스가 저장되어있다. 
		 */
		System.out.println("[출력1-일반for문]");
		for(int i=0 ; i<list2.size() ; i++) {
			/*
			List의 각 인덱스에 저장된 인스턴스의 참조값을 그대로 출력한다.
			toString()을 오버라이딩 했으므로 인스턴스에 저장된 멤버변수
			값을 출력할수 있다. 만약 오버라이딩 하지 않았다면 참조값이
			출력될것이다. 
			 */
			System.out.println(list2.get(i));
		}
		
		/*
		인스턴스의 참조값을 통해 삭제하는 경우 boolean값이 반환된다. 
		또한 동일한 인스턴스가 존재한다면 앞에 있는것이 먼저 삭제된다. 
		즉 동시에 삭제되지 않는다. 
		 */
		boolean removeOk = list2.remove(st2);//원빈삭제
		System.out.println("인스턴스를 통한 삭제:"+ removeOk); 
		
		/*
		컬렉션에 저장된 값을 통해 이터레이터 인스턴스를 생성한다. 
		반환할 인스턴스가 있는지 확인한 후 true이면 next()를 통해 
		출력한다. 
		 */
		System.out.println("[출력2-이터레이터]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {			 
			System.out.println(it2.next());
		} 
		
		/*
		시나리오] 컬렉션에 저장된 객체를 이름으로 검색하여 삭제할 수 
		있는 코드를 작성하시오. 이때 반복문은 확장for문을 사용하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String removeName = scanner.nextLine();
		
		//앞에서 1개를 삭제했으므로 4번 반복한다. 
		for(Student st : list2) {
			/*
			이름으로 검색시 멤버변수 name은 private으로 선언되었으므로
			getter를 통해 접근한다. 삭제를 위해 입력한 이름과 Student
			인스턴스에 저장된 name과 일치하는지 확인한 후 해당 인스턴스
			를 찾을 수 있다. 
			 */
			if(removeName.equals(st.getName())) {
				//정보가 일치하면 참조값을 통해 삭제한다. 
				list2.remove(st); 
				//삭제하는 즉시 반복문을 탈출한다. 
				break;
			}
		}
		System.out.println("현제 객체수:"+ list2.size()); 
		 
		/*
		인덱스를 통해 삭제하면 삭제된 인스턴스의 참조값을 반환한다. 따라서
		삭제에 성공한 경우 아래와 같이 이름을 즉시 출력할 수 있다. 
		 */
		System.out.println("삭제된 객체의 이름:"+ 
				list2.remove(2).getName());
		
		//남아있는 인스턴스의 전체 정보를 출력한다. 
		System.out.println("[출력3-확장for문]");
		for(Student st : list2) {
			System.out.println(st);
		}
	}
}
