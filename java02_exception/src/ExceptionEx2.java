import java.util.Scanner;

public class ExceptionEx2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionEx2() {
		
	}
	public void start() {
		try {
			System.out.print("첫번째 수->");
			// 콘솔의 문자열 1줄을 입력받는다.
			int num1 = Integer.parseInt(scan.nextLine());//----------!!!NumberFormatException
			System.out.print("두번째 수->");
			int num2 = Integer.parseInt(scan.nextLine());//------
			
			int result = num1 * num2;
			int result2 = num1 / num2;//-----------!!! Error(num2에 0값이 들어와 나누면 에러) = ArithmeticException
			
			System.out.println(num1+"*"+num2+"="+result);
			System.out.printf("%d/%d=%d\n",num1,num2,result2);
		
			String names[] = {"세종대왕","이순신",};
			for(int i=0; i<=names.length;i++) {//-----------Error(배열 index) = ArrayIndexOutOfBoundsException
				System.out.println("names["+i+"]="+names[i]);
			}
		//하위 클래스의 exception부터 선언해야한다.
		}catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("배열에서 예외발생....");
		//NumberFormatException과 ArithmeticException을 상속하고있는 상위 클래스인 Exception을 선언하여 묶어서 처리한다.
		}catch(Exception e) {
			System.out.println("0을 제외한 정수 입력하세요..--->"+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new ExceptionEx2().start();
	}

}
