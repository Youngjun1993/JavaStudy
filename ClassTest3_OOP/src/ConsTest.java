
public class ConsTest {
	String name;
	String tel;
	String addr;
	public ConsTest() {
		 System.out.println("생성자 실행됨.....");
	}
	public ConsTest(String name) {
		this();
		this.name = name;
	}
	public ConsTest(String name, String tel) {
		//this.name = name;
		this(name);
		this.tel = tel;
	}
	public ConsTest(String name, String tel, String addr) {
		//this.name = name;
		//this.tel = tel;
		//다른 생성자 메소드 호출하기 -- 첫번째줄 실행문에 작성
		this(name, tel);
		this.addr = addr;
		
	}
	public void print() {
		System.out.printf("%s, %s, %s\n",name,tel,addr);
	}
	public static void main(String[] args) {
		//ConsTest ct1 = new ConsTest();
		//ct1.print(); : null,null,null
		
		//ConsTest ct2 = new ConsTest("홍길동","010-7777-8888");
		//ct2.print(); : 홍길동,010-7777-8888,null
		
		ConsTest ct3 = new ConsTest("이순신","010-9999-2222","서울시 종로구");
		ct3.print();
		
	}
}
