package userSystemData;

public class UserLogin {
	public static String USER_ID = "user";
	public static String USER_PWD = "1234";
	
	public UserLogin() {}
	public static boolean UserLogin(String id, String pwd){
		USER_ID = id;
		USER_PWD = pwd;
		if(USER_ID.equals("user") && USER_PWD.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}
	
}
