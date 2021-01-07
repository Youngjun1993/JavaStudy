package emp;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	public EmpDataSet() {
		
	}
	public static void setEmpList() {
		empList.put("가가가", new EmpVO(1, "가가가", "01-111-1111", "총무부", "과장"));
		empList.put("나나나", new EmpVO(5, "나나나", "02-222-2222", "인사팀", "대리"));
		empList.put("다다다", new EmpVO(3, "다다다", "03-333-3333", "영업팀", "사원"));
		empList.put("라라라", new EmpVO(4, "라라라", "04-444-4444", "지원팀", "대리"));
		empList.put("마마마", new EmpVO(2, "마마마", "05-555-5555", "전산팀", "팀장"));
	}

}
