

import adminSystemData.AdminDataControl;
import adminSystemData.AdminDataSet;
import adminSystemData.AdminLogin;
import bookSystemData.BookDataSet;
import userSystemData.UserLogin;

// 관리자 로그인, 로그아웃 구현
// 로그인시 회원관리 리스트 출력
// 리스트에 맞는 이벤트 구현(회원조회, 회원수정, 회원추가, 회원삭제, 도서관리, 로그아웃, 종료)

// 도서관리 구현
// 리스트에 맞는 이벤트 구현(도서조회, 도서등록, 목록수정, 목록삭제, 회원관리, 종료)
// 회원관리 메뉴 선택시 회원관리 리스트 재출력

// 유저 로그인, 로그아웃 구현
// 로그인시 본인도서 리스트 출력
// 리스트에 맞는 이벤트 구현(도서조회, 도서구매, 도서대여, 도서반납, 도서구매권수)
// 회원조회에 보이는 구매 및 대여수는 도서관리에 재고량을 연동
// ex) 김길동 회원이 김김책을 구매시 도서관리 재고량 - / 회원관리 구매수 +

// 유저에서 입력된 데이터를 관리자에서 그대로 리스트출력되게끔 했음 좋겠다....

public class MainClass extends AdminDataControl{
	public MainClass() {}
	// 관리자 로그인 메소드
	public void AdLog() {
		while(true) {
			System.out.print("로그인하시겠습니까(관리자:1, 유저:2)?");
			String log = scan.nextLine();
			//관리자계정 로그인시 실행문
			if(log.equals("1")) {
				String adminId = msg("아이디");
				String adminPwd = msg("패스워드");
				if(AdminLogin.AdminLogin(adminId, adminPwd)) {
					System.out.println("★★★관리자 로그인 성공★★★");
					adminMenu(); // 회원관리 메뉴 출력
					break;
				}
				else {
					System.out.println("★★★아이디 혹은 비밀번호를 잘못입력했습니다.★★★");
				}
			}else if(log.equals("2")) {
				String userId = msg("아이디");
				String userPwd = msg("패스워드");
				if(UserLogin.UserLogin(userId, userPwd)) {
					System.out.println("★★★유저 로그인 성공★★★");
					userMenu();
					break;
					// 유저 로그인시 실행문
				}
				else {
					System.out.println("★★★아이디 혹은 비밀번호를 잘못입력했습니다.★★★");
				}
			}else {
				System.out.println("★★★잘못입력했습니다...제발요★★★");
			}
		}
	}
	// 전체메뉴
	public void adminMenu() {
		Out:while(true){
			System.out.println("");
			System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 회   원   관   리 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
			String adminIndex = msg("회원조회(1), 회원등록(2), 회원수정(3), 회원삭제(4), 도서관리(5), 로그아웃(6), 종료(z)");
			switch(adminIndex) {
				case "1":
					//회원조회 메소드 호출
					System.out.println("");
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 회   원   조   회 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
					adminConsole();
					break;
				case "2":
					//회원등록 메소드 호출
					System.out.println("");
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 회   원   등   록 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
					userAdd();
					break;
				case "3":
					//회원수정 메소드 호출
					System.out.println("");
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 회   원   수   정 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
					userEdit();
					break;
				case "4":
					//회원삭제 메소드 호출
					System.out.println("");
					System.out.println("◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ 회   원   삭   제 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇");
					userDel();
					break;
				case "5":
					bookMenu();
					break Out;
				case "6":
					System.out.println("★★★로그아웃 되었습니다.★★★");
					System.out.println("");
					AdLog();
					break Out;
				case "z":
					System.out.println("★★★프로그램이 종료되었습니다.★★★");
					break Out;
				default :
					System.out.println("★★★메뉴에 보여지는 키를 입력하시기 바랍니다.★★★");
			}
		}
	}
	//도서관리 메뉴
	public void bookMenu() {
		Out:while(true){
			System.out.println("");
			System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ 도   서   관   리 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
			String bookIndex = msg("도서조회(1), 도서등록(2), 목록수정(3), 목록삭제(4), 회원관리(5), 종료(z)");
			switch(bookIndex) {
				case "1":
					//도서조회
					System.out.println("");
					System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ 도   서   조   회 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
					bookConsole();
					break;
				case "2":
					//도서등록
					System.out.println("");
					System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ 도   서   등   록 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
					bookAdd();
					break;
				case "3":
					//목록수정 
					System.out.println("");
					System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ 목   록   수   정 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
					bookEdit();
					break;
				case "4":
					//목록삭제
					System.out.println("");
					System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ 목   록   삭   제 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆");
					bookDel();
					break;
				case "5":
					//회원관리
					adminMenu();
					break Out;
				case "z":
					//종료
					System.out.println("★★★프로그램이 종료되었습니다.★★★");
					break Out;
				default:
					System.out.println("★★★메뉴에 보여지는 키를 입력하시기 바랍니다.★★★");
					break;
			}
		}
	}
	//유저관리 메뉴
	public void userMenu() {
		Out:while(true) {
			System.out.println("");
			System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   관   리 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
			String userIndex = msg("도서조회(1), 도서구매(2), 도서대여(3), 도서반납(4), 도서보유내역(5), 로그아웃(6), 종료(z)");
			switch(userIndex) {
				case "1":
					//도서조회
					System.out.println("");
					System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   조   회 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
					bookConsole();
					break;
				case "2":
					//도서구매
					System.out.println("");
					System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   구   매 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
					bookGet();
					break;
				case "3":
					//도서대여
					System.out.println("");
					System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   대   여 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
					bookRent();
					break;
				case "4":
					//도서반납
					System.out.println("");
					System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   반   납 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
					bookReturn();
					break;
				case "5":
					//도서구매권수
					System.out.println("");
					System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈ 도   서   보   유   내  역 ◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
					userConsole();
					break;
				case "6":
					System.out.println("★★★로그아웃 되었습니다.★★★");
					System.out.println("");
					AdLog();
					break Out;
				case "z":
					//종료
					System.out.println("★★★프로그램이 종료되었습니다.★★★");
					break Out;
				default:
					System.out.println("★★★메뉴에 보여지는 키를 입력하시기 바랍니다.★★★");
					break;
			}
		}
	}
	// main 메소드
	public static void main(String[] args) {
		AdminDataSet.setUserList();	// 회원데이터 초기값
		BookDataSet.bookDataList(); // 도서데이터 초기값
		new MainClass().AdLog();
	}
}
