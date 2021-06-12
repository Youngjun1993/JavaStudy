import pac.Access2;

public class AccessMain {
	
	public AccessMain() {
		
	}
	
	public void Start() {
		//객체생성
		Access1 a1 = new Access1();
		
		//System.out.println("a1.userid = "+a1.userid);//객체.멤버변수
		System.out.println("a1.userpwd = "+a1.userpwd);
		a1.printData();
		
		Access2 a2 = new Access2(); //패키지가 다르다. 접근 제어자가 default다
		//System.out.println("a2.num = "+a2.num);//객체.멤버변수
		//System.out.println("a2.name = "+a2.name);
		System.out.println("a2.getName() = "+ a2.getName());
		System.out.println("a2.getNum() = "+ a2.getNum());
		a2.setNum(200);
		System.out.println("a2.getNum() = " + a2.getNum());
		a2.setName("영준");
		System.out.println("a2.getName() = " + a2.getName());
	}
	
	public static void main(String[] args) {
		new AccessMain().Start();
	}

}
