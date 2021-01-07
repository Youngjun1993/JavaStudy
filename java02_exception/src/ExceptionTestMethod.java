
public class ExceptionTestMethod {
	// method1()에서 에러가 발생하기 때문에 해당 메소드도 예외처리를 해줘야해서 생성자 메소드에 예외처리
	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{
		method1();
	}
	
	public void method1() throws ArithmeticException, NumberFormatException, ArrayIndexOutOfBoundsException{
		int a=100, b=10;
		int c= a/b;
		System.out.println("c="+c);
		method2();
	}
	public void method2() throws NumberFormatException, ArrayIndexOutOfBoundsException{
		String numStr = "12";
		int num=Integer.parseInt(numStr);	// NumberFormatException
		System.out.println("num="+num);
		method3();
	}
	public void method3() throws ArrayIndexOutOfBoundsException {
		int num[]= {10,20,30};
		System.out.println(num[num.length]);
	}
	public static void main(String[] args){
		try {
			new ExceptionTestMethod();
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 없습니다.-->"+ae.getMessage());
		}catch(NumberFormatException nf) {
			System.out.println("문자는 숫자로 변경할 수 없습니다.");
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 첨자값을 잘못 입력했습니다.");
		}
		System.out.println("프로그램 종료.....");
	}

}
