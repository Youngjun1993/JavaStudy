
public class StaticTest {
	// 멤버변수
	/*
	   초기값을 설정하지 않은 경우 각 자료형별 디폴트값
	   - 정수:0, 실수:0.0, 논리형:false, 객체형:null
	*/
	// static을 사용하면 객체를 몇개를 생성하던 각각 값이 대입되는게 아니라 static이 선언된 하나의 값으로 사용된다.
	/* ex) 멤버변수 int num = 100이였을때 
	       st.num=200, st2.num=300, st3.num=100 이라고 각각 설정 가능했다면
	       static int num = 100이라면 st,st2,st3 의 num은 100이 된다.
	   즉 static 멤버변수는 객체를 생성시 공통변수로 사용된다.
	*/
	static int num = 100;
	String name = "세종대왕";
	
	public StaticTest() {
		
	}
	// StaticTest 객체를 생성하지 않고 바로 호출할수 있게 static메소드 사용
	public void prn() {
		System.out.println("num->" + num);
		System.out.println("nam->" + name);
	}
}
