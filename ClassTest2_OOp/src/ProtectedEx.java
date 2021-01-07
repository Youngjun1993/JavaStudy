
public class ProtectedEx {

	protected String username = "세종대왕";
	
	protected ProtectedEx() {
		System.out.println("protected 실행돼니?");
	}
	protected void print() {
		System.out.println("username =>>>>> " + username);
	}

}
