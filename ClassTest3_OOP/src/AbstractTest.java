//추상클래스 : 추상메소드를 포함하고있다.
//			class 이전에 abstract이라고 표기해야 한다.
//			추상클래스는 객체 생성을 할 수 없고 추상클래스를 상속 받아 모든 추상메소드를 오버라이딩하여야한다.
public abstract class AbstractTest {
	int num = 1234;
	String name = "홍길동";
	public AbstractTest() {
		
	}
	public void total() {
		int sum=0;
		for(int i=1; i<=100; i+=2) {
			sum += i;
		}
		this.num = sum;
	}
	//추상메소드 : 반드시 반환형 이전에 abstract(예약어)를 표기하여야 한다.
	public abstract void output();
	public abstract void sum(int max);
}
