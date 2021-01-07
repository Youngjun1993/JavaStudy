import java.util.Scanner;

public class EmailCheckEx_Ans {
	Scanner scan = new Scanner(System.in);
	
	public EmailCheckEx_Ans() {
		do {
			// 이메일 입력
			System.out.print("이메일입력=");
			String email = scan.nextLine();	// 한줄 입력
			int atMark = email.indexOf("@");	// @ : at mark라 부른다.
			int point = email.indexOf(".");
			
			int pointCnt=0;
			for(int i=0;i<email.length();i++) {	// i=0,1,2,3,4......
				if(email.charAt(i) == '.') {
					pointCnt++;
				}
			}
			
			if(atMark == -1 || point == -1 || atMark > point || (point-atMark)<3 || pointCnt>2) {	// 잘못된 이메일 주소
				System.out.println(email + "주소는 잘못된 이메일 주소 입니다");
			}else {	// 정상 이메일 주소
				// goguma@nate.com	: String.split, StringTokenizer
				String emailResult[] = email.split("@");
				
				String id = email.substring(0, atMark);		// 골뱅이 앞부터 끝까지
				String domain = email.substring(atMark + 1);// 골뱅이 뒤부터 끝까지
				
				System.out.println("아이디="+emailResult[0]);
				System.out.println("도메인="+ domain);
			}
			
		}while(true);
	}

	public static void main(String[] args) {
		new EmailCheckEx_Ans();
	}

}
