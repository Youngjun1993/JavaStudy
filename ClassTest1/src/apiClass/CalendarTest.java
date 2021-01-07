package apiClass;


import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 현재 시스템의 날짜, 시간관련 정보를 객체로 생성한다.
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		// 날짜를 변경하기
		now.set(2021, 4, 28); // 2021년 5월 28일
		
		// set(int field, int value)
		// 년도변경 : 
		now.set(Calendar.YEAR, 2025);
		now.set(Calendar.MONTH, 0);
		now.set(Calendar.DAY_OF_MONTH, 1);
		
		// 2020-12-24 11:55(목)
		int y = now.get(Calendar.YEAR);// 년	 / now.get(1)과 같다
		// MONTH는 1월이 0이다. 떄문에 +1을 해줘야한다.
		int m = now.get(Calendar.MONTH) + 1;// 월	/ now.get(2)+1과 같다
		int d = now.get(Calendar.DAY_OF_MONTH); // 일	/ now.get(1)과 같다
		
		int h = now.get(Calendar.HOUR_OF_DAY); // 시
		int mi = now.get(Calendar.MINUTE); // 분
		
		int w = now.get(Calendar.DAY_OF_WEEK); // 요일 / 일:1, 월:2, 화:3, 수:4, 목:5, 금:6, 토:7
		
		String weekStr = "";
		// int보다 작은 정수, char, String
		switch(w) {
			case 1: weekStr = "일"; break;
			case 2: weekStr = "월"; break;
			case 3: weekStr = "화"; break;
			case 4: weekStr = "수"; break;
			case 5: weekStr = "목"; break;
			case 6: weekStr = "금"; break;
			case 7: weekStr = "토";
		}
		
		System.out.printf("%d-%d-%d %d:%d(%s)\n", y, m, d, h, mi, weekStr);
		
		////////////////////////////////////
		int yearMax = now.getActualMaximum(Calendar.YEAR);
		System.out.println("yearMax = " + yearMax);
		int monthMax = now.getActualMaximum(Calendar.MONTH);
		System.out.println("monthMax = " + monthMax);
		int dayMax = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("dayMax = " + dayMax);
	}


}
