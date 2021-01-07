import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// Key, Value가 무조건 둘다 String인 컬렉션
		Properties prop = new Properties();
		
		prop.setProperty("네이트", "https://www.nate.com");
		prop.setProperty("다음", "https://www.daum.net");
		prop.setProperty("네이버", "https://www.naver.com");
		prop.setProperty("비트캠프", "https://www.bitcamp.co.kr");
		
		String url = prop.getProperty("비트캠프");
		System.out.println("비트캠프->"+url);
		
		//Key목록 구하기
		
		Enumeration key = prop.propertyNames();
		while(key.hasMoreElements()) {
			String k = (String)key.nextElement();
			System.out.println("key="+k+", value ="+prop.getProperty(k));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();
	}

}
