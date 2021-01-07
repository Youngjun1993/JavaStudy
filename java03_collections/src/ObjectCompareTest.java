import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		//객체내의 특정 필드로 정렬하기
		//ArrayList는 보통 상위 클래스인 List에 넣는다.
		List<Member> lst = new ArrayList<Member>();
		
		lst.add(new Member(4,"홍길동","010-1111-1111","강원도 삼척시"));
		lst.add(new Member(3,"이순신","010-2222-2222","부산광역시"));
		lst.add(new Member(1,"세종대왕","010-3333-3333","서울시 중구"));
		lst.add(new Member(2,"김정희","010-4444-4444","경기도 안산시"));
		lst.add(new Member(5,"장영실","010-5555-5555","대전직할시"));
		
		System.out.println("=============정렬전============");
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("===========이름을 이용한 내림차순 정렬");
		
		//정렬하기
		Collections.sort(lst,new CompareNameDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("===========이름을 이용한 오름차순 정렬");
		Collections.sort(lst, new CompareNameAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("===========번호를 이용한 오름차순 정렬");
		Collections.sort(lst, new CompareNoAsc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
		System.out.println("===========번호를 이용한 내림차순 정렬");
		Collections.sort(lst, new CompareNoDesc());
		for(Member mem : lst) {
			mem.memberPrn();
		}
	}
	//번호를 오름차순으로 정렬하는 내부 클래스
	class CompareNoAsc implements Comparator<Member>{
		@Override
		public int compare(Member m1, Member m2) {
			//m1:작으면 -1, 같으면 0, m1이 크면+1
			return (m1.getNo() < m2.getNo()) ? -1 : (m1.getNo()==m2.getNo()) ? 0 : 1;
		}
	}
	//번호를 내림차순으로 정렬하는 내부 클래스
		class CompareNoDesc implements Comparator<Member>{
			@Override
			public int compare(Member m1, Member m2) {
				//m1:작으면 -1, 같으면 0, m1이 크면+1
				return (m1.getNo() < m2.getNo()) ? 1 : (m1.getNo()==m2.getNo()) ? 0 : -1;
			}
		}
	
	//이름을 오름차순으로 정렬하는 내부 클래스
	class CompareNameAsc implements Comparator<Member>{
		@Override
		public int compare(Member m1, Member m2) {
			return m1.getUsername().compareTo(m2.getUsername());
		}
	}
	
	//이름을 내림차순으로 정렬기준을 정의하는 내부클래스
	// ** Comparator 인터페이스를 상속받아 compare메소드를 오버라이딩한다.(규칙)
	class CompareNameDesc implements Comparator<Member>{
		//	음수, 0, 양수 -> 음수 : 오른쪽에 있는 객체(m2)가 크다./ 0 : 같다. / 양수 : 왼쪽에 있는 객체(m1)가 크다.
		//  -1, 0, 1
		@ Override
		public int compare(Member m1, Member m2) {
			//		  홍길동						 이순신
			//return m1.getUsername().compareTo(m2.getUsername()); // 양수처리는 오름차순 정렬
			//		  이순신						 홍길동
			return m2.getUsername().compareTo(m1.getUsername()); // 음수처리로 하여 내림차순 정렬
		}
	}
	public static void main(String[] args) {
		new ObjectCompareTest();
	}

}
