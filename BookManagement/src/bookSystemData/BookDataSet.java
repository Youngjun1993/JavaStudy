package bookSystemData;

import java.util.HashMap;

public class BookDataSet {
	public static HashMap<String, BookVO> bookData = new HashMap<String, BookVO>();
	public BookDataSet() {}
	public static void bookDataList() {
		// 순번, 도서명, 저자명, 출판사, 가격, 재고량
		bookData.put("1", new BookVO("1","철학자와 늑대","마크 롤랜즈","추수밭",30000,8));
		bookData.put("2", new BookVO("2","안녕, 바람","강원 랜드요","탐",25000,3));
		bookData.put("3", new BookVO("3","식탁 위의 세상","켈시 티머먼","부키",28000,5));
	}
}
