import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		// List, 
		// Queue : 객체를 한쪽에서 추가 다른쪽에서 제거한다.
		// Deque : 객체를 양쪽에서 추가, 제거할 수 있다.
		// 객체를 pop하면(Output하면) 컬렉션에서 객체가 지워진다.
		
		LinkedList<String> ll = new LinkedList<String>();
		// 데이터 추가
		ll.offer("홍길동");
		ll.offer("세종대왕");
		ll.offer("이순신");
		ll.offer("김정희");
		ll.offerFirst("Hong");
		// 저장된 순서
		// offer -> 김정희 / 이순신 / 세종대왕 / 홍길동 -> pop //
		//			3		2		1		0
		//			2		1		0		X	-> pop
		//			1		0		X		X	-> pop
		
		/// 제일 마지막 객체를 pop
		System.out.println(ll.pollLast());
		System.out.println(ll.get(1)); // 객체가 지워지지 않는다.
		
		while(!ll.isEmpty()) {//컬렉션이 비어있는지 확인 후 true, false리턴
			System.out.println("pop->"+ll.pop());
		}
		
		// 객체수
		System.out.println("size()->"+ll.size());
	}

	public static void main(String[] args) {
		new LinkedListTest();
	}

}
