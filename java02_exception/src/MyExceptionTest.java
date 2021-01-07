import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
		try {
			System.out.print("1~10까지의 정수 입력=");
			int data = scan.nextInt();	// InputMismatchException
			if(data<1 || data>10) {
				//throw : 강제 예외 발생
				//throw new MyException();
				throw new MyException("1에서 10까지 정수가 아니다.");
			}else {
				//정상처리
				sum(data);
			}
		}catch(MyException e) {
			e.printStackTrace();
		}
	}
	public void sum(int m) {
		int s = 0;
		for(int i=1;i<m;i++) {
			s += i;
		}
	}
	public void start() {
		
	}
	public static void main(String[] args) {
		new MyExceptionTest();
	}

}
