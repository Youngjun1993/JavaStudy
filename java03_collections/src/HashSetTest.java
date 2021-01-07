import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set : 입력순서 유지하지 않음, 중복데이터 허용하지 않음.
		int numData[] = {10,50,30,40,10,50,60,70,40,40,40,40};
		String strData[] = {"홍길동","세종대왕","홍길동","홍길동","이순신","이순신","김정희"};
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int n : numData) {
			hs1.add(n);
		}
		System.out.println("hs1의 객체수="+hs1.size());
		
		HashSet<String> hs2 = new HashSet<String>();
		for(String s : strData) {
			hs2.add(s);
		}
		System.out.println("hs2의 객체수="+hs2.size());
		/////////////////////
		// iterator()를 하게되면 순서가 없는 데이터를 줄을 세운다고 생각하면 된다.(index 없음)
		// 컬렉션 종류와 상관없이 데이터를 나열해준다.
		// 제일 앞에있는 것을 Output이 가능함.
		// 객체 유무 확인 hasNext() / 다음 객체 지정 next() / 객체 삭제 remove()
		Iterator<Integer> i = hs1.iterator();
		while(i.hasNext()) {
			System.out.println("hs1-->"+i.next());
		}
		
		Iterator<String> str = hs2.iterator();
		while(str.hasNext()) {
			System.out.println("hs2-->"+str.next());
		}
	}

	public static void main(String[] args) {
		new HashSetTest();
	}

}
