

//public, default
public class ProtectedTest {
	
	protected String username = "세종대왕";
	public ProtectedTest() {
		System.out.println("protected 실행돼니?");
	}
	protected void print() {
		System.out.println("username = " + username);
	}

}
