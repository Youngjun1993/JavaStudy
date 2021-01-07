import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
	
	}
	public Vector getdata() {
		int num	= 12;
		String name = "홍길동";
		Member member = new Member();
		Member member2 = new Member(500,"이순신","010-7777-8888","서울시 종로구 통인동");
		Calendar now = Calendar.getInstance();
		Random ran = new Random();
		
		//입력순서유지, index를 가진다, 중복데이터를 허용한다, 중간에 객체를 추가or삭제,수정할 수 있다
		Vector v = new Vector();
		// 배열에 추가할 수 있는 메서드
		// add(E e) = E : Object이다 라고 생각하면된다.,addElement(E obj), add(int index, E element) 
		v.add(num);// v.add(new Integer(num)); 인데 오토박싱으로 잡아줘서 가능
		v.addElement(name); //add와 addElent는 같다.
		v.add(member);
		v.add(member2);
		v.addElement(now);
		v.addElement(ran);
		
		// 추가
		v.add(3,new String("hong gil dong"));
		
		System.out.println("v.capacity="+v.capacity()); // capacity() = 확보된 메모리공간확인, 공간은 알아서 확장이 된다.
		
		return v;
	}
	
}
