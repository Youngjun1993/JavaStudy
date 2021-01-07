
// getter setter가 있는 클래스를 VO, DTO라고 부른다.
// VO : 정보 한개를 넣는 기능을 가지고 있다. Value Object
// DTO : Data Type Object
// 보통 클래스명에 붙여놓는다. ex) MemberVO or MemberDTO
public class Member {
	private int no=1234;
	private String username="세종대왕";
	private String tel="010-4578-4577";
	private String addr="서울시 마포구 백범로";
	public Member() {
	
	}
	public Member(int no, String username, String tel, String addr) {
		this.no=no;
		this.username=username;
		this.tel=tel;
		this.addr=addr;
	}
	public void memberPrn() {
		System.out.printf("%d, %s, %s, %s\n",no,username,tel,addr);
	}
	//getter, setter
	//규칙 : get or set다음 가저올 변수명 앞글자는 대문자로 기입
	//가져올 변수만큼 따로 만들어 준다
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
