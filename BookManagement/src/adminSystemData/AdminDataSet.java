package adminSystemData;

import java.util.HashMap;

public class AdminDataSet {
	public static HashMap<String, AdminVO> userList = new HashMap<String, AdminVO>();
	public AdminDataSet() {}
	public static void setUserList() {
		userList.put("1", new AdminVO("1","유저1","010-1111-1111","가동",1));
		userList.put("4", new AdminVO("4","유저4","010-4444-4444","라동",4));
		userList.put("2", new AdminVO("2","유저2","010-2222-2222","나동",2));
		userList.put("3", new AdminVO("3","유저3","010-3333-3333","다동",3));
		userList.put("5", new AdminVO("5","유저1","010-5555-5555","마동",5));
	}
	
}
