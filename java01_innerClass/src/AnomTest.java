//익명의 내부클래스 구현하기
public class AnomTest {

	public AnomTest() {
		start();
	}
	public void start() {
		//익명의 내부클래스 : 변수에는 대입 불가능
		new Sample() {
			//실행부
			public void oddSum(int max) {// Sample클래스의 메소드 오버라이딩
				int s=0;
				for(int i=1;i<=max;i+=2) {
					s=s+i;
				}
				System.out.println("1~"+max+"까지의 홀수의 합은 "+s);
			}
		}.oddSum(100); //호출하기
	}
	public static void main(String[] args) {
		new AnomTest();
	}

}
