// 패키지

// import문 = 다른 클래스를 사용할때 객체 또는 상속을 받아 사용할 때 클래스가 있는 위치를 알려준다.
//		      ** 즉 패키지가 다른 클래스를 사용하고 싶을때 사용. 제한없이 사용 가능하다. **

import pac.AAA;// ex)AAA클래스에서 있는 객체가 필요할때
// import java.lang.String;  = java패키지에 String클래스의 디폴트다
// import java.lang.System;  = java패키지에 System 클래스의 디폴트다
// 위와 같이 첫글자가 대문자인 클래스들은 main함수 안에 있을경우 디폴트값을 javac(컴파일러)가 자동으로 임폴트해준다.
// import java.util.*; java = 패키지, * = 모든 클래스
// import java.util.Calendar; = Calendar라는 클래스를 (ctrl + space)로 import 시켜준것

/* 
  	public == 접근 제한자
  	public이 들어간 클래스는 다른폴더에 있는 클래스에서 사용할 수 있다.
  	ex) public A(F폴더) / B(FF 폴더)라면 B가 A를 사용할 수 있다.
 	
 	A = public class A		공유 클래스라고 부른다.
 	B = class b				디폴트 클래스라고 부른다.
 	
 */

public class Calculator {	
		// 멤버영역 : 실행문을 구현할수 없다.
		
		// 멤버변수 : 해당 클래스 어디에든 사용할 수 있는 변수
		
		// 생성자 메소드 : 객체를 만들때 실행되는 메소드
		
		// 메소드 : 기능구현을 하는데 호출해줘야 실행되는 메소드
	
		// 메인메소드
		
		// 내부클래스
	public static void main(String args[]) {
		// 다른 클래스에서 구현한 기능을 사용할때
		// 1. 객체 생성(new):생성자 메소드		2. 상속
		// 	   레퍼런스 변수(클래스를 담은 변수)
		Aclass obj = new Aclass(); // 불러오는 클래스는 선언과 동시에 실행된 상태가 된다.
		// 레퍼런스 변수에 넣은 클래스에 있는 모든 것을 사용할 수 있다.
		// 하지만 기본적으로 선언된 생성자 메소드만 실행된다.
		// 즉 위 코드는 Aclass명을 가진 클래스에 멤버변수(전역변수), 메소드, 생성자 메소드를 사용할 수 있다. 
		
		int num = 100;
		System.out.println("obj="+ obj); // 주소값 = @53153245 를 해쉬코드라고 부른다.
	
		
		Aclass obj2 = new Aclass(10,5,"hong");
		
		Aclass obj3 = new Aclass(120);
		
		
		// 객체내의 메소드 호출
		obj2.total();
		int result = obj.sum(100);
		int sumMax = obj3.sum(100);
		System.out.println("result = " + result);
		
		String s = new String();
		// 바이트형에 값을 넣어주면 그 값을 문자형으로 변환해 ss라는 래퍼런스 변수에 넣어준다.
		String ss = new String(new byte[] {65,66,67,68,69}); 
		System.out.println(ss);
		
		String sss = new String(new char[] {'T','E','S','T'});
		System.out.println(sss);
	}
	
}
