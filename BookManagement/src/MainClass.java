import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
	int NoIndex = 6;
	public MainClass() {}
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
				AdminDataSet.setUserList();	// 데이터 초기값
				adminMenu(); // 선택 메뉴 출력
			}
			else {
				System.out.println("아이디 혹은 비밀번호를 잘못입력했습니다.");
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
			System.out.println("   "+vo.getUserNo()+",      "+vo.getUserName()+",    "+vo.getUserTel()+",   "+vo.getUserAddr()+",\t   "+vo.getUserBookCnt());
		}
	}
	// 전체메뉴
	public void adminMenu() {
		Out:do {
			String index = msg("회원조회(1), 회원등록(2), 회원수정(3), 회원삭제(4), 종료(아무키)");
			switch(index) {
				case "1":
					//회원조회 메소드 호출
					console();
					break;
				case "2":
					//회원등록 메소드 호출
					userAdd();
					break;
				case "3":
					//회원수정 메소드 호출
					userEdit();
					break;
				case "4":
					//회원삭제 메소드 호출
					userDel();
					break;
				default :
					break Out;
			}
		}while(true);
	}
	// 회원등록
	public void userAdd() {
		while(true) {
			try{
				String addUserNo = NoIndex + "";
				String addUserName = msg("회원명을 입력하세요");
				String addUserTel = msg("회원연락처를 입력하세요");
				String addUserAddr = msg("회원주소를 입력하세요");
				int addUserBookCnt = Integer.parseInt(msg("북인덱스를 입력하세요"));
				AdminDataSet.userList.put(addUserNo, new AdminVO(addUserNo, addUserName, addUserTel, addUserAddr, addUserBookCnt));
			}catch(NumberFormatException nfe){
				System.out.print("숫자를 입력하세요.");
			}
			String reAdd = msg("추가로 등록하시겠습니까(네:1, 아니오:2)");
			++NoIndex;
			if(reAdd.equals("2")) {
				console();
				break;
			}
		}
	}
	// 회원수정
	public void userEdit() {
		console();
		// 키값입력
		String key = msg("수정할 회원번호를 입력하세요");
		AdminVO vo = AdminDataSet.userList.get(key);
		if(vo == null) {
			System.out.println("존재하지않는 회원번호입니다.");
		}else{
			// 수정값 선택
			String editIdx = msg("수정할 내용을 선택하세요(이름:1,연락처:2,주소:3,북인덱스:4,종료:아무키");
			
			if(editIdx.equals("1")) {
				String editUserName = msg("수정될 이름을 입력하세요:");
				vo.setUserName(editUserName);
			}else if(editIdx.equals("2")) {
				String editUserTel = msg("수정될 연락처를 입력하세요.");
				vo.setUserAddr(editUserTel);
			}else if(editIdx.equals("3")) {
				String editUserAddr = msg("수정될 주소를 입력하세요.");
				vo.setUserAddr(editUserAddr);
			}else if(editIdx.equals("4")) {
				String editUserBook = msg("수정될 BookCnt을 입력하세요.");
				vo.setUserBookCnt(Integer.parseInt(editUserBook));
			}
			System.out.println("수정이 완료되었습니다:D");
		}
	}
	// 회원삭제
	public void userDel() {
		console();
		String key = msg("삭제할 회원번호를 입력하세요");
		AdminVO vo = AdminDataSet.userList.get(key);
		if(vo == null) {
			System.out.println("존재하지않는 회원번호입니다.");
		}
		else {
			AdminDataSet.userList.remove(key);
			System.out.println("삭제가 완료되었습니다:D");
		}
	}
	public static void main(String[] args) {
		new MainClass().AdLog();
	}

}
