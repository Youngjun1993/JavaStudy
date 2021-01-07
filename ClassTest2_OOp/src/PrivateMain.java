class PrivateChild extends PrivateParent{
	
	PrivateChild(){
		//private 접근제어자가 있는 멤버변수는 상속되지 않는다.
		//System.out.println("num = " + num);
		setNum();
		//private 접근제어자가 메소드 상속되지 않는다.
		//super.setNum();
	}
	//오버라이딩 override, 반환형 , 메소드명, 매개변수가 같은 것을 재정의한다.
	//현재 클레스에서 정의된 메소드
	private void setNum() {
		age += 2;
	}
}
///////////////////////////////////////////////////////
public class PrivateMain {

	public PrivateMain() {
		
	}

	public static void main(String[] args) {
		PrivateChild pc = new PrivateChild();
		System.out.println("pc.getNum() ====="+ pc.getNum());
		//   				private 객체명을 통합 접근은 불가능하다.
		//System.out.println("pc.num ===="+ pc.num);
	}

}
