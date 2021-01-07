// 상속하지 않는다.
// public final class FinalTest {
public class FinalTest {
	// 한번 값이 설정되면 수정할 수 없다.
	// 상속가능
	final int STATUS;
	public FinalTest() {
		STATUS = 2;
	}
	// 하위클래스에서 total()은 override 할수 없는 메소드가 된다.
	// 상속가능
	public final void total() {
		int i=0;
		for(int j=1; j<100; j+=2) {
			i += j;
		}
		System.out.println("1~100까지의 홀수의 합은 "+i);
	}
}
