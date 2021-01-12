package bookSystemData;

public class BookVO {
	private String idx;
	private String bookName;
	private String writer;
	private String company;
	private int price;
	private int bookCnt;
	public BookVO(String idx, String bookName, String writer, String company, 
			int price, int bookCnt) {
		this.idx = idx;
		this.bookName = bookName;
		this.writer = writer;
		this.company = company;
		this.price = price;
		this.bookCnt = bookCnt;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBookCnt() {
		return bookCnt;
	}
	public void setBookCnt(int bookCnt) {
		this.bookCnt = bookCnt;
	}

}