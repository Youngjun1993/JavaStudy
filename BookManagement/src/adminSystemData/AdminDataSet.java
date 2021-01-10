package adminSystemData;

import java.util.HashMap;

public class AdminDataSet {
	public static HashMap<String, AdminVO> userList = new HashMap<String, AdminVO>();
	public AdminDataSet() {}
	public static void setUserList() {
		userList.put("1", new AdminVO("1","장성훈","010-1548-9058","가동",6));
		userList.put("4", new AdminVO("4","오은비","010-3568-4784","나동",8));
		userList.put("2", new AdminVO("2","이태성","010-1645-3548","다동",6));
		userList.put("3", new AdminVO("3","박단비","010-2268-2245","라동",12));
		userList.put("5", new AdminVO("5","김영진","010-7878-9295","마동",22));
	}
	
}
