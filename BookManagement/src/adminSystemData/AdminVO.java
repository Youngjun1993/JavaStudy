package adminSystemData;

public class AdminVO {
	private int userBookCnt;
	private String userNo;
	private String userName;
	private String userTel;
	private String userAddr;
	
	public AdminVO() {}
	public AdminVO(String userNo, String userName, String userTel, 
			String userAddr, int userBookCnt) {
		this.userNo = userNo;
		this.userName = userName;
		this.userTel = userTel;
		this.userAddr = userAddr;
		this.userBookCnt = userBookCnt;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public int getUserBookCnt() {
		return userBookCnt;
	}
	public void setUserBookCnt(int userBookCnt) {
		this.userBookCnt = userBookCnt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

}
