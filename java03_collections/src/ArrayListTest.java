import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		
		//다른 종류의 객체 추가 가능
		ArrayList al = new ArrayList();
		
		// 제너릭을 사용하여 Member객체만 추가 가능한 래퍼런스변수를 만든다.
		List<Member> lst = new ArrayList<Member>();
		
		Member mem1 = new Member(100, "hong", "010-1234-5688", "서울시 서대문구");
		Member mem2 = new Member(200, "kim", "010-4587-8888", "서울시 종로구");
		Member mem3 = new Member(300, "park", "010-7895-9696", "서울시 중구");
	
		al.add(mem1); // ArrayList 0번쨰 인덱스
		al.add(mem2); // 1
		al.add(mem3); // 2
		
		lst.add(mem1);
		lst.add(mem2);
		lst.add(mem3);
		
		al.add(new String("홍길동"));
		//lst.add(new String("세종대왕")); = Error //generic(제너릭)은 같은 종류의 객체만 추가가능하다.
		
		//			  객체를 담은 클래스이기 때문에 size 선언
		for(int i=0; i<lst.size(); i++) { //0,1,2
			Member m = lst.get(i); //제너릭 컬렌션의 형변환하지 않아도 된다.
			//Member m1 = (Member)al.get(i); = 제너릭을 설정하지않아 형변환이 필요하다.
			m.memberPrn();
		}
	}
	
	public static void main(String[] args) {
		new ArrayListTest();
	}

}
