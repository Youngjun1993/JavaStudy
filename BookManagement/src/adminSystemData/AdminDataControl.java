package adminSystemData;

import java.util.Iterator;
import java.util.Set;

import userSystemData.UserDataControl;

public class AdminDataControl extends UserDataControl{
	int NoIndex = 6;
	public AdminDataControl() {}
	
	// 회원데이터 리스트 콘솔 출력 메소드
		public void adminConsole() {
		Set<String> dataList = AdminDataSet.userList.keySet();
		Iterator<String> ii = dataList.iterator();
		System.out.println("회원번호,    회원명,    회원연락처,         회원주소,    구매 및 대여수");
		while(ii.hasNext()){
			AdminVO vo = AdminDataSet.userList.get(ii.next());
			System.out.println("   "+vo.getUserNo()+",      "+vo.getUserName()+",    "+vo.getUserTel()+",   "+vo.getUserAddr()+",\t   "+vo.getUserBookCnt());
		}
	}
	// 회원등록
	public void userAdd() {
		while(true) {
			try{
				String addUserNo = NoIndex + "";
				String addUserName = msg("회원명을 입력하세요");
				String addUserTel = msg("회원연락처를 입력하세요");
				String addUserAddr = msg("회원주소를 입력하세요");
				int addUserBookCnt = Integer.parseInt(msg("구매권수를 입력하세요"));
				AdminDataSet.userList.put(addUserNo, new AdminVO(addUserNo, addUserName, addUserTel, addUserAddr, addUserBookCnt));
			}catch(NumberFormatException nfe){
				System.out.print("★★★숫자를 입력하세요.★★★");
			}
			String reAdd = msg("추가로 등록하시겠습니까(네:1, 아니오:2)");
			++NoIndex;
			if(reAdd.equals("2")) {
				adminConsole();
				break;
			}
		}
	}
	// 회원수정
	public void userEdit() {
		while(true) {
			adminConsole();
			// 키값입력
			String key = msg("수정할 회원번호를 입력하세요");
			AdminVO vo = AdminDataSet.userList.get(key);
			if(vo == null) {
				System.out.println("존재하지않는 회원번호입니다.");
			}else{
				// 수정값 선택
				String editIdx = msg("수정할 내용을 선택하세요(이름:1, 연락처:2, 주소:3, 구매권수:4, 종료:아무키");
				try {
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
						String editUserBook = msg("수정될 구매권수를 입력하세요.");
						vo.setUserBookCnt(Integer.parseInt(editUserBook));
					}
					System.out.println("수정이 완료되었습니다:D");
					break;
				}catch(NumberFormatException nfe) {
					System.out.println("★★★숫자를 입력해주세요.★★★");
				}
			}
		}
	}
	// 회원삭제
	public void userDel() {
		adminConsole();
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

}
