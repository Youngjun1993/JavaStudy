package apiClass;

public class StringBufferTest {
	
	// StringBuffer : 문자열을 비동기식으로 처리, 문자열이 자주 바뀌는 경우 유용
	public StringBufferTest() {
		StringBuffer sb = new StringBuffer();
	
		// append() : 기존 문자열에 문자 추가(끝에)
		sb.append(true);
		sb.append("Spring");
		
		// insert() : 문자열 중간에 문자 삽입
		sb.insert(5, "Mybatis");
		
		// delete() : 시작 인덱스번호부터 끝 인덱스번호 앞까지 삭제
		sb.delete(4, 10);
		
		// reverse() : 문자열 앞, 뒤 순서 변경 
		sb.reverse();
		
		System.out.println("sb = " + sb);
		
		// 메모리 확인
		System.out.println("capacity = " + sb.capacity());
		
			
	
	}
	
	public static void main(String[] args) {
		new StringBufferTest();
	}
}
