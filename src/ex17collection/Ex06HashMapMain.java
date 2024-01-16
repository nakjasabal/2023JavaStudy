package ex17collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
HashMap<K,V>
: Map<T> 인터페이스를 구현한 컬렉션
-Key, Value의 쌍으로 인스턴스를 저장한다. 
-Key는 중복될 수 없다. 만약 중복되면 기존의 데이터를 덮어쓰기한다. 
-Key를 통해 검색되므로 다른 컬렉션에 비해 속도가 빠르다. 
-저장 순서는 유지되지 않는다. 
 */
public class Ex06HashMapMain {

	public static void main(String[] args) {
		
		/*
		Map컬렉션 생성. Key와 Value를 모두 String으로 선언함. 
		 */
		HashMap<String, String> map = new HashMap<String, String>();
	 
		/*
		인스턴스저장 : 최초 저장이라면 성공시 null을 반환한다. 만약
		  기존에 이미 저장된 동일한 Key가 존재하면 저장된 인스턴스가
		  반환된다. 
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+
				map.put("name", "홍길동")); 
		int number = 20;
		//int형은 String으로 변환할 수 없으므로 타입에러 발생됨
		//map.put("age", number);
		//정술는 아래와 같이 문자열로 변경한 후 저장할 수 있다. 
		map.put("age", String.valueOf(number));
		map.put("gender", "남자");
		map.put("address", "가산디지럴단지");
		//현재까지 4개의 데이터 저장 
		System.out.println("저장된 객체수:"+ map.size());
		
		/*
		중복저장 : 기존에 입력된 name이라는 Key가 있으므로 "홍길동"이
		 	반환된다. 그리고 기존의 값은 "최길동"으로 수정된다. */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+
				map.put("name", "최길동"));//덮어쓰기
		//중복 저장되므로 4개가 출력된다. 
		System.out.println("키값으로 중복 저장후 객체수:"+ 
				map.size());

		/*
		출력하기
		1.Key를 알고있을때 : get(key) 으로 출력한다. 
		 */
		System.out.println("키값을 알때:"+ map.get("name")); //최길동
		
		/*
		2.Key를 모를때(혹은 너무 많아서 하나씩 명시하기 힘들때)
		: keySet()을 통해 전체 Key를 얻어온다. 이를 통해 for문으로
		순차적인 접근을 하면된다. 
		 */
		Set<String> keys = map.keySet();
		System.out.println("[확장for문 적용]");
		for(String key : keys) {
			//get(key값)을 통해 value를 출력한다. 
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}

		/*
		3.이터레이터 사용
		: 이터레이터를 통해 출력할때도 keySet()을 통해 전체 Key를
		얻어온 후 반복출력한다. 
		 */
		System.out.println("[이터레이터 사용하기]");
		//Map의 전체 Key를 얻어온 후
		Set<String> keys2 = map.keySet();
		//이터레이터 인스턴스를 생성한다. 
		Iterator<String> it = keys2.iterator();
		//Key가 있는지 확인한 후
		while(it.hasNext()) {
			//존재하면 Key를 반환한다. 
			String key = it.next();
			//Key를 통해 Value를 인출하여 출력한다. 
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}

		System.out.println("[value값들만 출력하기]");
		/*
		Value만 얻어올때는 values()를 통해 값을 인출할 수 있다. 
		반환되는 값은 Collection<T> 타입이다. 
		 */
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}

		/*
		인스턴스의 존재유무 확인
		: Map컬렉션은 Key와 Value가 있으므로 메서드도 아래와같이
		2개로 나눠져있다. 
		 */
		System.out.println(map.containsKey("name") ?
				"name키값있다" : "name키값없다");
		System.out.println(map.containsKey("account") ?
				"account키값있다" : "account키값없다");
		System.out.println(map.containsValue("남자") ?
				"남자 있다" : "남자 없다");
		System.out.println(map.containsValue("여자") ?
				"여자 있다" : "여자 없다");

		/*
		인스턴스삭제 : Key를 통해 삭제하고, 삭제에 성공하면 해당 Value가
			반환된다. 
		 */
		System.out.println("삭제된객체:"+ map.remove("age"));//20출력
		System.out.println("[age키값을 삭제후 출력]");
		for(String key : keys) {
			System.out.println(String.format("%s:%s", key, map.get(key)));
		}
		
		/*
		전체삭제 : removeAll()은 없고, clear()만 사용할 수 있다. 
		 */
		map.clear();
		System.out.println("전체삭제후 객체수:"+ map.size());
	}
}


