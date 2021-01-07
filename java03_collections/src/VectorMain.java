import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {}

	public static void main(String[] args) {
		VectorTest vt = new VectorTest();
		Vector vv = vt.getdata();
	
		//컬렉션의 객체를 얻어오기 - 객체를 꺼내써도 지워지지 않는다.(vector의 특징)
		Member m1 = (Member)vv.elementAt(2); // 현재 member는 VectorTest클래스에서 add메서드로 Object객체로 만들어 넣었기때문에 강제 형변환(타입캐스팅)이 필요하다.
		Calendar date = (Calendar)vv.get(5);
		
		m1.memberPrn();
		System.out.println(date);
	
		System.out.println("객체의 수 -->"+vv.size());
		//마지막 객체 얻어오기
		Random ran = (Random)vv.lastElement();
		System.out.println("난수="+ran.nextInt());
		
		//객체 지우기
		vv.remove(3);			// index를 선언하면 그 자리에 있는 요소가 지워지고 뒤에있는 요소가 앞으로 온다.
		vv.removeAllElements(); // 객체를 전부 지운다 = 0이됨
		System.out.println("");
	}

}
