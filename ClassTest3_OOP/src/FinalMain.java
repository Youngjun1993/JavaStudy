
public class FinalMain extends FinalTest {

	public FinalMain() {

	}
	public void start() {
		System.out.println("STATUS="+STATUS);
		//total(); // 현재 클래스의 메소드 실행
		total(); // 상위 클래스의 메소드 실행
		totalEven(100);
	}
	public void totalEven(final int k) {
		//k=200; Error / final변수이므로 값을 변경할 수 없다.
		System.out.println("1~100까지의 짝수의 합은 2550");
	}
	public static void main(String[] args) {
		new FinalMain().start();
	}

}
