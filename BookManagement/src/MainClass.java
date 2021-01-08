import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import adminSystemData.AdminDataSet;
import adminSystemData.AdminLogin;
import adminSystemData.AdminVO;

// 관리자 로그인, 로그아웃 구현
// 로그인시 회원관리 리스트 출력
// 리스트에 맞는 이벤트 구현(회원조회, 회원수정, 회원추가, 회원삭제)

// 유저 로그인, 로그아웃 구현
// 로그인시 본인도서 리스트 출력
// 리스트에 맞는 이벤트 구현(도서조회, 도서구매, 도서대여, 도서반납, QnA(?))

// 유저에서 입력된 데이터를 관리자에서 그대로 리스트출력되게끔 했음 좋겠다....

public class MainClass {
	Scanner scan = new Scanner(System.in);
	public MainClass() {
		
	}
	// 관리자 로그인 메소드
	public void AdLog() {
		System.out.print("로그인하시겠습니까(관리자:1, 유저:2)?");
		String log = scan.nextLine();
		//관리자계정 로그인시 실행문
		if(log.equals("1")) {
			String adminId = msg("아이디");
			String adminPwd = msg("패스워드");
			if(AdminLogin.AdminLogin(adminId, adminPwd)) {
				System.out.println("관리자로그인 성공!!");
				AdminDataSet.setUserList();	// 데이터 초기 셋팅
				console();
			}
		}else if(log.equals("2")) {
			
		}else {
			System.out.println("잘못입력했습니다..제발 질문좀 잘보세요.");
		}
		
	}
	// 메시지 입력 메소드
	public String msg(String msg) {
		System.out.print(msg+"=");
		String txt = scan.nextLine();
		return txt;
	}
	// 데이터 리스트 콘솔 출력 메소드
	public void console() {
		Set<String> dataList = AdminDataSet.userList.keySet();
		Iterator<String> ii = dataList.iterator();
		System.out.println("회원번호,    회원명,    회원연락처,         회원주소,    구매 및 대여수");
		while(ii.hasNext()){
			AdminVO vo = AdminDataSet.userList.get(ii.next());
			System.out.println("   "+vo.getUserNo()+",      "+vo.getUserName()+",     "+vo.getUserTel()+",   "+vo.getUserAddr()+",\t     "+vo.getUserBookCnt());
		}
	}
	public static void main(String[] args) {
		new MainClass().AdLog();
	}

}
