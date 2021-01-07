
// 클래스를 상속받은 시 extends를 이용한다.
// 클래스는 1개만 상속받을 수 있다.
// 상위 클래스가 먼저 실행된 후 자신의 클래스에 있는걸 실행한다.
public class Sedan extends Car {
	// 하위클래스에서 변수를 상위클래스의 변수와 같은 변수를 정의할 수 있다.
	String carColor = "Orange";
	int speedMax = 150;
	public Sedan() {
		System.out.println("Sedan()생성자메소드");
	}
	public Sedan(String carName,String carColor) {
		//상위 클래스의 생성자를 호출하는 방법
		//상위 클래스의 생성자 호출은 첫번째행으로 표시한다.
		super("그랜져",50,"Gray");
		
		// this = 현재클래스의 있는~. / 현재클래스에 없는 변수명이 상위클래스에 있을때 this를 써도 상위클래스에 있는 변수를 사용한다.
		// super = 상위클래스의 있는~. (상속시에만 적용) / 같은 변수명일때 사용
		this.carName = carName;
		super.carColor = carColor;
		System.out.println("Sedan(String,String)생성자");
	}
	public void start() {
		System.out.println("색상:"+carColor);
		System.out.println("색상(parent):"+ super.carColor);
		System.out.println("이름:"+carName);
	}
	// 상속받아서 재정의 하는걸 오버라이딩이라고 한다.
	public void speedUp() {
		speed += 15;
		if(speed > 150) {
			speed = 150;
		}
	}
	public static void main(String[] args) {
		Sedan s = new Sedan();
		s.speedUp();
		System.out.println("s.speedUp()="+s.speed);
		//s.start();
		//Sedan ss = new Sedan("레오","Blue");
		//ss.start();
	}

}
