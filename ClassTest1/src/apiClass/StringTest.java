package apiClass;

public class StringTest {

	public StringTest() {
		String data = "서울시 마포구 백범로";	// 객체 생성을 생략할수 있다.(String만)
		String data2 = new String("서울시 마포구 백범로"); // 위와 같다.
	
		if(data == data2) {
			System.out.println(data+"과 "+data2+"는 같다.");
		}else {
			System.out.println(data+"과 "+data2+"는 다르다.");
		}
	
		if(data.equals(data2)) {	// data2.equals(data)
			System.out.println("data와 data2는 같다.");
		}else {
			System.out.println("data와 data2는 다르다.");
		}
		
		// charAt() : index위치의 문자 반환
		char result1 = data.charAt(5);
		System.out.println("charAt() = " + result1);
		
		// concat() : 문자열의 연결, ex) data+data2
		String data3 = "Java OOP programing....";
		String data4 = "java oop programing....";
		String result2 = data.concat(data3);
		System.out.println("concat() = " + result2);
		
		// equals() : 대소문자 구별하여 비교
		boolean boo1 = data3.equals(data4);
		System.out.println("equals() = " + boo1);
		
		// equalsIgnoreCase() : 대소문자 구별하지 않고 비교
		boolean boo2 = data3.equalsIgnoreCase(data4);
		System.out.println("equalsIgnoreCase() = " + boo2);
		
		// getBytes() : 문자열을 byte 배열로 변환한다.
		byte result3[] = data3.getBytes();
		for(byte b : result3) {	// 배열 출력 for문
			System.out.println(b + "-->" + (char)b);
		}
		
		// indexOf() : 특정 문자의 위치 index를 구해준다. / 값이 존재하지 않을경우 : -1 반환
		int result4 = data3.indexOf("OOP");		// 위치의 시작점 index번호를 반환한다.
		int result4_2 = data3.indexOf("OOP",10);// 10 위치부터 찾아 반환한다.
		System.out.println("indexOf() = " + result4);
		System.out.println("indexOf() = " + result4_2);
		
		// length() : 문자 수 반환
		int result5 = data3.length();
		System.out.println("length() = " + result5);
		
		// replaceAll() : 특정 위치의 문자열을 변경
		String result6 = data3.replaceAll("OOP","객체");
		System.out.println("replaceAll() = " + result6);
		
		// split() : 특정 문자로 문자열을 조각내서 배열로 만든다
		String tel = "010-1234-5678";
		String result7[] = tel.split("-");
		for(int i=0; i<result7.length; i++) {
			System.out.println("tel[" + i + "] = " + result7[i]);
		}
		
		// substring() : 문자열의 일부 구하기
		String result8 = data3.substring(5);		// index 5부터 끝까지의 문자열을 구한다.
		System.out.println("substring() = " + result8);
		String result9 = data3.substring(5, 10);	// index 5부터 index 10앞(9)까지의 문자열을 구한다.
		System.out.println("substring() = " + result9);
		
		// toLowerCase() : 소문자로 변경
		System.out.println("toLowerCase() = " + data3.toLowerCase());
		// toUpperCase() : 대문자로 변경
		System.out.println("toUpperCase() = " + data3.toUpperCase());
	
		
		// compareTo() : 문자를 아스키코드값으로 비교해서 ( 0-> 두값은 같다/ 양수 -> 왼쪽 문자가 큼 / 음수 -> 오른쪽 문자가 크다.)를 반환
		String str1 = "Oracle";
		String str2 = "oracle";
		int result10 = str1.compareTo(str2);
		System.out.println("compareTo() = " + result10);
		
		// Trim() : 공백제거
		String str3 = "    Java Programing    ";
		System.out.println("trim = " + str3.trim());
		
		// valueOf() : 기본데이터 타입 + char배열을 문자열로 변환하는 메소드
		int num = 1234;
		String numTxt = String.valueOf(num);
		System.out.println("valueOf() = " + numTxt);
		
		String num2 = "5678";
		
		// Integer
		// 해당라인 이하부터 자바버전 1.5 이하부터는 에러다.
		Integer num2Int = Integer.valueOf(num2);	// 데이터 타입 = Integer
		
		Integer numInt = 1234;				 // 오토박싱 : 기본 데이터형이 객체형으로 대입
		int num3 = Integer.valueOf(9999);	 // 오토언박싱 : 객체형 데이터가 기본 데이터형으로 대입
		
		// 1.5 이하부터는 아래와 같이 new를 사용해 반드시 객체를 생성하여줘야한다.
		Integer numInt2 = new Integer(1234);
		
		/*
		char c = 'A';
		c++;
		c = (char)(c + 1);
		System.out.println("c => " + c);
		c = (char)(c + 3);
		System.out.println("c => " + c);
		
		// 형변환시 원하는 값이 안나올 수 있다. 무조건 형변환 해버리면 안된다.
		byte b = (byte)130;
		System.out.println(b);
		*/
	}

	
	
	public static void main(String[] args) {
		new StringTest();
	}

}
