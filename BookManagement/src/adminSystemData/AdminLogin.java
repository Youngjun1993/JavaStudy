package adminSystemData;

public class AdminLogin {
	public static String ADMIN_ID = "admin";
	public static String ADMIN_PWD = "0000";
	
	public AdminLogin() {}
	
	public static boolean AdminLogin(String id, String pwd){
		ADMIN_ID = id;
		ADMIN_PWD = pwd;
		if(ADMIN_ID.equals("admin") && ADMIN_PWD.equals("0000")) {
			return true;
		}else {
			return false;
		}
	}

}
