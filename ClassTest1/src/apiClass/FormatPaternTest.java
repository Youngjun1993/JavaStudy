package apiClass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatPaternTest {

	public FormatPaternTest() {
		try {// 예외처리
			// 숫자 포멧
			int won = 56567854;
			//		  56,567,854원
			DecimalFormat dFmt= new DecimalFormat("#,###원");
			String wonStr = dFmt.format(won);
			System.out.println("wonStr="+wonStr);
			
			// 패턴화 된 데이터를 원래데이터로 돌려 놓기
			NumberFormat nFmt = NumberFormat.getInstance(); // 자기 자신 클래스를 객체로 리턴하는 메소드 : getInstance()
			// 패턴화 된 데이터를 NumberFormat에 파싱한다.
			Number num = nFmt.parse(wonStr);
			int numValue = num.intValue();
			System.out.println("numValue="+numValue);
			
			// 날짜 패턴	2021-01-04(월) 11:25 오전
			String pattern = "yyyy-MM-dd(E) hh:mm a";
			SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
			
			Calendar now = Calendar.getInstance();//날짜
			// String	format(Date date)
			String dateStr = dateFmt.format(now.getTime());
			System.out.println("dataStr="+dateStr);
			
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new FormatPaternTest();
	}

}
