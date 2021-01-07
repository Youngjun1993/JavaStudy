
public class MyException extends Exception {
	
	//1~10까지의 값만 유효한 값입니다. < 예외 메세지로 설정
	public MyException() {
		super("1~10까지의 값만 유효한 값입니다.");
	}
	//매개변수의 값이 예외 메세지로 설정
	public MyException(String message) {
		super(message);
		
	}
}
