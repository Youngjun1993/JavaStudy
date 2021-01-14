package userSystemData;

import java.util.Iterator;
import java.util.Set;

import bookSystemData.BookDataControl;
import bookSystemData.BookDataSet;
import bookSystemData.BookVO;

public class UserDataControl extends BookDataControl{
	BookVO bVO;
	UserVO uVO = new UserVO("","","","",0,0);
	String key;
	int bookCnt=0;
	int bookCntAdmin = 0;
	public UserDataControl() {
	
	}
	// 도서구매
	public void bookGet() {
		bookConsole();
		key = msg("- 구매할 순번을 입력하세요");
		if(UserDataSet.userData.get(key) == null) {
			bookCnt=0;
		}
		bookCnt++;
		
		BookVO vo = BookDataSet.bookData.get(key);
		bVO = vo;
		if(vo == null) {
			System.out.println("★★★존재하지않는 순번입니다.★★★");
		}
		else {
			int num = BookDataSet.bookData.get(key).getBookCnt()-1;
			BookDataSet.bookData.get(key).setBookCnt(num);
			uVO.setBookCntUser(bookCnt);
			
			UserDataSet.userData.put(bVO.getIdx(), new UserVO(bVO.getIdx(), bVO.getBookName(),bVO.getWriter(), bVO.getCompany(), bVO.getPrice(), uVO.getBookCntUser()));
			System.out.println("구매가 완료되었습니다:D");
		}
	}
	// 도서대여
	public void bookRent() {
		bookConsole();
		key = msg("- 구매할 순번을 입력하세요");
		if(UserDataSet.userData.get(key) == null) {
			bookCntAdmin=0;
			bookCnt=0;
		}
		bookCnt++;
		BookVO vo = BookDataSet.bookData.get(key);
		bVO = vo;
		if(vo == null) {
			System.out.println("★★★존재하지않는 순번입니다.★★★");
		}
		else {
			int num = BookDataSet.bookData.get(key).getBookCnt()-1;
			BookDataSet.bookData.get(key).setBookCnt(num);
			uVO.setBookCntUser(bookCnt);
			
			UserDataSet.userData.put(bVO.getIdx(), new UserVO(bVO.getIdx(), bVO.getBookName(),bVO.getWriter(), bVO.getCompany(), bVO.getPrice(), uVO.getBookCntUser()));
			System.out.println("구매가 완료되었습니다:D");
		}
	}
	// 도서반납
	public void bookReturn() {
		userConsole();
		String key = msg("- 반납할 순번을 입력하세요");
		UserVO vo = UserDataSet.userData.get(key);
		if(vo == null) {
			System.out.println("★★★대여내역이 존재하지않거나 순번을 잘못입력했습니다.★★★");
		}else {
			int num = BookDataSet.bookData.get(key).getBookCnt()+1;
			BookDataSet.bookData.get(key).setBookCnt(num);
			bookCnt--;
			uVO.setBookCntUser(bookCnt);
			UserDataSet.userData.put(bVO.getIdx(), new UserVO(bVO.getIdx(), bVO.getBookName(),bVO.getWriter(), bVO.getCompany(), bVO.getPrice(), uVO.getBookCntUser()));
			System.out.println("반납이 완료되었습니다:D");
		}
	}
	// 도서구매권수
	public void userConsole() {
		if(bVO == null) {
			System.out.println("★★★보유내역이 존재하지 않습니다.★★★");
		}else {
			UserDataSet.userData.put(bVO.getIdx(), new UserVO(bVO.getIdx(), bVO.getBookName(),bVO.getWriter(), bVO.getCompany(), bVO.getPrice(), uVO.getBookCntUser()));
			
			Set<String> dataList = UserDataSet.userData.keySet();
			Iterator<String> ii = dataList.iterator();
			System.out.println("  순번,\t도서명,\t\t저자명,\t\t출판사,\t   구매가격,   구매 및 대여수");
			while(ii.hasNext()) {
				UserVO vo = UserDataSet.userData.get(ii.next());
				System.out.println("  "+vo.getIdxUser()+",\t"+vo.getBookNameUser()+",\t"+vo.getWriterUser()+",\t"+vo.getCompanyUser()+",\t   "+vo.getPriceUser()+",        "+vo.getBookCntUser());
			}
		}
	}
}
