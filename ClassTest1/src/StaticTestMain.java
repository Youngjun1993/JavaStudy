
public class StaticTestMain {

	public static void main(String[] args) {
		
		//클래스내의 메소드를 호출하기 위해 객체를 생성
		//StaticTest st = new StaticTest();
		//st.prn(); //호출
		
		// static 멤버변수는 객체를 생성시 공통변수로 사용된다.
		StaticTest st = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		// 값변경
		st.num = 1234;
		st.name = "이순신";
		
		st2.prn();
		///////////////////////////////////////////////////
		
		// 멤버변수에 static키워드를 사용하면 클래스를 객체생성 하지 않고 사용할 수 있다.
		// static = 객체를 생성하지않고 함수 혹은 멤버변수를 호출할 수 있게 해준다.
		// 							  클래스명.static멤버변수
		System.out.println("num-->" + StaticTest.num);
	
		// static 메소드 호출
		// 클래스명.static메소드
		//StaticTest.prn();
	}

}
