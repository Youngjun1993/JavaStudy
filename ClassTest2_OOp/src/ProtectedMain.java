public class ProtectedMain extends ProtectedTest{

	public ProtectedMain() {
		
	}
	
	public void start() {
		//protected 접근제한자는 같은 패키지일 경우 접근허용
		//					  다른 패키지일 경우 상속받아서 접근허용
		//ProtectedTest pt = new ProtectedTest();
		//ProtectedEx pe = new ProtectedEx();
		//System.out.println("------" + pe.username);
		//pe.print();
		System.out.println("이름 = "+ username);
		print();
	}
	public static void main(String[] args) {
		new ProtectedMain().start();
	}

}
