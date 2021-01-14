package userSystemData;

public class UserVO {
	private String idxUser;
	private String bookNameUser;
	private String writerUser;
	private String companyUser;
	private int priceUser;
	private int bookCntUser = 0;
	private int bookCntadmin = 0;
	public UserVO(String idxUser, String bookNameUser, String writerUser, String companyUser, 
			int priceUser, int bookCntUser) {
		this.idxUser = idxUser;
		this.bookNameUser = bookNameUser;
		this.writerUser = writerUser;
		this.companyUser = companyUser;
		this.priceUser = priceUser;
		this.bookCntUser = bookCntUser;
	}
	public int getBookCntadmin() {
		return bookCntadmin;
	}
	public void setBookCntadmin(int bookCntadmin) {
		this.bookCntadmin = bookCntadmin;
	}
	public String getIdxUser() {
		return idxUser;
	}
	public void setIdxUser(String idxUser) {
		this.idxUser = idxUser;
	}
	public String getBookNameUser() {
		return bookNameUser;
	}
	public void setBookNameUser(String bookNameUser) {
		this.bookNameUser = bookNameUser;
	}
	public String getWriterUser() {
		return writerUser;
	}
	public void setWriterUser(String writerUser) {
		this.writerUser = writerUser;
	}
	public String getCompanyUser() {
		return companyUser;
	}
	public void setCompanyUser(String companyUser) {
		this.companyUser = companyUser;
	}
	public int getPriceUser() {
		return priceUser;
	}
	public void setPriceUser(int priceUser) {
		this.priceUser = priceUser;
	}
	public int getBookCntUser() {
		return bookCntUser;
	}
	public void setBookCntUser(int bookCntUser) {
		this.bookCntUser = bookCntUser;
	}

}
