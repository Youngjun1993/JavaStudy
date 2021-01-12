package bookSystemData;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BookDataControl{
	public Scanner scan = new Scanner(System.in);
	int bookIndex = 4;
	public BookDataControl() {}
	// 메시지 입력 메소드
	public String msg(String msg) {
		System.out.print(msg+" = ");
		String txt = scan.nextLine();
		return txt;
	}
	// 도서데이터 리스트 콘솔 출력 메소드
	public void bookConsole() {
		Set<String> dataList = BookDataSet.bookData.keySet();
		Iterator<String> ii = dataList.iterator();
		System.out.println("  순번,\t도서명,\t\t저자명,\t\t출판사,\t   판매가격,\t   재고량");
		while(ii.hasNext()) {
			BookVO vo = BookDataSet.bookData.get(ii.next());
			System.out.println("  "+vo.getIdx()+",\t"+vo.getBookName()+",\t"+vo.getWriter()+",\t"+vo.getCompany()+",\t   "+vo.getPrice()+",\t   "+vo.getBookCnt());
		}
	}
	// 도서등록
	public void bookAdd() {
		while(true) {
			try{
				String addbookNo = bookIndex + "";
				String addbookName = msg("도서명을 입력하세요");
				String addwriter = msg("저자명을 입력하세요");
				String addcompany = msg("출판사를 입력하세요");
				int addprice = Integer.parseInt(msg("판매가격을 입력하세요"));
				int addBookCnt = Integer.parseInt(msg("재고량을 입력하세요"));
				BookDataSet.bookData.put(addbookNo, new BookVO(addbookNo, addbookName, addwriter, addcompany, addprice, addBookCnt));
			}catch(NumberFormatException nfe){
				System.out.print("★★★숫자를 입력하세요.★★★");
			}
			String reAdd = msg("추가로 등록하시겠습니까(네:1, 아니오:2)");
			++bookIndex;
			if(reAdd.equals("2")) {
				bookConsole();
				break;
			}
		}
	}
	// 목록수정
	public void bookEdit() {
		while(true) {
			bookConsole();
			// 키값입력
			String key = msg("- 수정할 순번을 입력하세요");
			BookVO vo = BookDataSet.bookData.get(key);
			if(vo == null) {
				System.out.println("존재하지않는 순번입니다.");
			}else{
				// 수정값 선택
				String editIdx = msg("수정할 내용을 선택하세요(도서명:1, 저자명:2, 출판사:3, 판매가격:4, 재고량:5, 종료:6");
				try {
					if(editIdx.equals("1")) {
						String editBookName = msg("수정될 도서명을 입력하세요:");
						vo.setBookName(editBookName);
					}else if(editIdx.equals("2")) {
						String editWriter = msg("수정될 저자명을 입력하세요.");
						vo.setWriter(editWriter);
					}else if(editIdx.equals("3")) {
						String editCompany = msg("수정될 출판사를 입력하세요.");
						vo.setCompany(editCompany);
					}else if(editIdx.equals("4")) {
						String editPrice = msg("수정될 판매가격을 입력하세요.");
						vo.setPrice(Integer.parseInt(editPrice));
					}else if(editIdx.equals("5")) {
						String editUserBook = msg("수정될 재고량을 입력하세요.");
						vo.setBookCnt(Integer.parseInt(editUserBook));
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
		public void bookDel() {
			bookConsole();
			String key = msg("- 삭제할 회원번호를 입력하세요");
			BookVO vo = BookDataSet.bookData.get(key);
			if(vo == null) {
				System.out.println("★★★존재하지않는 회원번호입니다.★★★");
			}
			else {
				BookDataSet.bookData.remove(key);
				System.out.println("삭제가 완료되었습니다:D");
			}
		}
}
