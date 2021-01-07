
public class TypeCasting {

	public TypeCasting() {
		BBB b1 = new BBB();
		b1.print();
		b1.nameprint();
		
		//하위클래스로 객체를 생성하여 상위클래스 변수에 대입가능
		AAA a1 = new BBB();
		a1.print();
		//a1.nameprint(); //AAA클래스에는 BBB클래스가 숨겨져 있다.
		
		//typeCasting.
		BBB b2 = (BBB)a1;
		b2.nameprint();
		
		//상위 클래스의 객체를 하위클래스의 레퍼런스변수에 대입할 수 없다.
		AAA a2 = new AAA();
		//BBB b3 = (BBB)a2; = Error
		//b3.nameprint();	= Error
		
		///////////////////////////////////
		BBB b3 = new BBB();
		b3.output();
		//하위클래스에서 오버라이딩 된 메소드는 상위클래스로 타입캐스팅 하더라도
		//			메소드가 존재한다.
		AAA a3 = b3;
		a3.output();
		
		Object obj = new BBB();
		BBB b4 = (BBB)obj;
		b4.nameprint();
	}

	public static void main(String[] args) {
		new TypeCasting();
	}

}
