//추상클래스를 상속받는다.
public class AbstractMain extends AbstractTest {

	public AbstractMain() {
	
	}
	//추상메소드 오버라이딩
	public void output() {
		System.out.println("num--->"+num);
		System.out.println("name--->"+name);
	}
	public void sum(int max) {
		int total = 0;
		for(int i=0; i<=max;i++) {
			total+=i;
		}
		System.out.println("1~"+max+"까지의 합은 "+total);
	}
	public void start() {
		
	}
	
	
	
	
	public static void main(String[] args) {
		AbstractMain am = new AbstractMain();
		am.sum(100);
		
		//AbstractTest at = new AbstactTest(); = Error / 추상클래스를 객체화 할 수 없다.
		
		
	}

}
