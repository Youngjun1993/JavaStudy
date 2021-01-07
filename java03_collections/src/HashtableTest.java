import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}
	public void start() {
		//key, Value를 가진다.
		//Hashtable : 동기화선언
		//HashMap : 동기화지원하지 않음(동시에 여러명이 사용가능)
	
		//회원정보 4명을 hashtable에 저장
		Hashtable<String, Member> ht = new Hashtable<String, Member>();
		Member m1 = new Member(100,"홍길동","010-1111-2222","서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200,"세종대왕","010-2222-3333","서울시 종로구"));
		ht.put("이순신", new Member(300,"이순신","010-3333-4444","서울시 서대문구"));
		ht.put("김정희", new Member(400,"김정희","010-4444-5555","서울시 마포구"));
		ht.put("세종대왕2", new Member(200,"세종대왕","010-2222-3333","서울시 종로구"));
		ht.put("이순신2", new Member(300,"이순신","010-3333-4444","서울시 서대문구"));
		ht.put("김정희2", new Member(400,"김정희","010-4444-5555","서울시 마포구"));
		
		//Key를 기준으로 가져오기 : Key값을 알고 있을 경우
		Member vo = ht.get("세종대왕");
		vo.memberPrn();
		//-----------Map의 Key목록을 구하기 : Set으로 return된다.
		Set<String> keyList = ht.keySet();
		Object[] obj = keyList.toArray();
		for(Object o : obj) {
			System.out.println(o);
		}
		System.out.println("----------- Key값 사용해서 Value 목록 얻어오기");
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			//System.out.println(ii.next());
			Member v = ht.get(ii.next());
			v.memberPrn();
		}
		//----------- Key값 사용안하고 전체 Value 목록을 얻어오기
		System.out.println("----------- Key값 사용안하고 전체 Value 목록 얻어오기");
		Collection<Member> value = ht.values();
		Iterator<Member> iii = value.iterator();
		while(iii.hasNext()) {
			Member vvv = iii.next();
			vvv.memberPrn();
		}
	}
	public static void main(String[] args) {
		new HashtableTest().start();
	}

}
