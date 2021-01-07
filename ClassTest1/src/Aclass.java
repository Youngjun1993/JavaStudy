import java.util.Iterator;
import java.util.Scanner;

public class Aclass {
	// 멤버 변수 or 전역 변수
 	int num = 500;
	String username = "홍길동";
	
	Scanner scan = new Scanner(System.in);
	
	// 생성자 메소드
	// 1. 생성자 메소드는 클래스명과 생성자 메소드명이 같다.
	// 2. 메소드는 반드시 소괄호()가 있다.
	// 3. 생성자 메소드는 반환값이 없다.
	//    메소드의 반환값은 반환값의 자료형을 사용하나 반환(return) 받을 값이 없다면 void를 사용한다.
	// 4. 매개변수(arguments)는 갯수의 제한이 없다.
	// 5. 생성자 메소드는 객체 생성시 한번만 실행된다.
	// 6. 객체 생성시 여러개의 생성자 메소드 호출하는 방법 : this함수 사용
	public Aclass(int num, String name) {
		// 지역변수(매개변수)명과 멤버변수명이 같을때 멤버변수를 지정하는 키워드 : this
		/* 멤버에 있는 매개변수와 생성자 메소드에 사용할 멤버변수명이 같을때 this를 사용해서
		   중복된 이름을 구분지어 멤버변수라고 알려준다.
		   * 하지만 굳이 같은 변수명을 사용할 필요가 없다 !! *
		*/
		this.num = num;		// this.변수명은 멤버에 있는 변수라는 뜻이다.
		username = name;
	}
	
	public Aclass() {								// new Aclass()
		System.out.println("Aclass()생성자 실행됨...");
		// total(); // 메소드 호출
		
	}
	public Aclass(int n) {							// new Aclass(10)
		//this: 다른 생성자 호출실행
		//반드시 첫번째 실행문으로 처리해야 한다. 즉 첫번째 줄에 기재해야한다.
		this(); // Aclass() 가 실행된다.
		System.out.println("Aclass(int n)실행->" + n);
	}
	public Aclass(int x, int y, String name) {		// new Aclass(10,20,"이영준")
		System.out.println("Aclass(int x, int y, String name)->" + x +"," + y+"," + name);
	}
	public Aclass(int a, int c, double firstName) {// new Aclass(10,20,5.3)
		System.out.println("Aclass(int a, int c, double firstName)->"+ a +"," + c +"," + firstName);
	}
	
	
	// 메소드 : 1 ~ 100까지 합
	// 	  [반환형]	메소드명:소문자 시작하고 소괄호()가 있다.
	public void total() {
		//구현
		int tot = 0;
		for(int i = 1; i <= 100; i++) {
			tot += i;
		}
		System.out.printf("tot=%d \n",tot);
	}
	
	// 메소드 : 임의의 값을 전달받아 그 수까지 합
	public int sum(int max) {
		int sum = 0;
		for(int i = 1; i <= max; i++) {
			sum+=i;
		}
		//System.out.println("sum = " + sum);
		return sum;
	}
	
	
}
