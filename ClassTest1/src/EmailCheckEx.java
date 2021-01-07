import java.util.Arrays;
import java.util.Scanner;

// 이영준
public class EmailCheckEx {
	String email;
	
	public EmailCheckEx() {
		
	}
	
	// 이메일 입력
	public String EmailInput(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " = ");
		return sc.next();
	}
	
	// 이메일 오류 체크
	public void EmailErrCheck() {
		while(true) {
			String errCheckAr1[] = email.split("@");
			String errCheckAr2[] = email.split("\\.");
			
			// @와 .으로 잘랐을때의 갯수를 파악해 오류를 출력
			// .의 갯수가 하나이나 이메일 아이디에 .이 들어가있는지 확인
			if(errCheckAr1.length != 2 || 
					errCheckAr2.length != 2 ||
						errCheckAr1[0].contains("\\.")) {
				System.out.println(email + "는 잘못입력된 메일입니다....");
				email = EmailInput("이메일 입력");
			}
			else {
				EmailOutput(errCheckAr1[0], errCheckAr1[1]);
				break;
			}
		}
	}
	
	// 이메일 아이디 및 도메인 출력
	public void EmailOutput(String id, String domain) {
		System.out.println("아이디 = " + id);
		System.out.println("도메인 = " + domain);
	}
	
	// 클래스 시작 메소드
	public void start() {
		email = EmailInput("이메일 입력").trim();
		EmailErrCheck();
	}
	
	// main 메소드
	public static void main(String[] args) {
		EmailCheckEx obj = new EmailCheckEx();
		obj.start();
	}

}
