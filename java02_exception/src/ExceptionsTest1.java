import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsTest1 {
	
	public ExceptionsTest1() {
		try {
			// 예외처리하기
			// 예외발생 가능한 코드와 예외발생 가능성이 없는 코드도 명시가 가능하다.
			Scanner scan = new Scanner(System.in);
			System.out.print("정수를 입력하세요...");
			int n = scan.nextInt();
			System.out.println("n="+n);
		} catch (InputMismatchException ime) { // 발생한 에러를 ime 변수에 담는다
			//try영역의 코드가 예외가 발생하면 실행될 영역
			ime.printStackTrace();//에러를 종료하고 에러내역을 보여준다.
			
			//System.out.println(ime.getMessage());
			
			//System.out.println("숫자를 잘못입력하였습니다..");
		}
		//System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new ExceptionsTest1();
	}
	
}
