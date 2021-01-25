import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	//2. DB 연결변수 선언	 Url , 계정명, 계정비밀번호			
	String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
	String userid = "c##scott";
	String userpwd = "tiger";
	Connection conn = null;
	
	//1. jdbc 드라이브 로딩
	//멤버영역에 실행문 사용하는법, * 원래는 실행문은 멤버영역에 사용하지 못하고 또 하지않는게 좋으나 아래와 같은 드라이브경로 등과 같은 경우는 사용해주는게 좋다.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이브가 로딩 되었습니다.");
		}catch(ClassNotFoundException cne) {
			System.out.println("JDBC드라이브가 로딩 실패 ==>" + cne.getMessage());
		}
	}
	public InsertTest() {
		try {
			//2.DB연결									  Url , 계정명, 계정비밀번호
			Connection conn = DriverManager.getConnection(url, userid, userpwd);
			
			//자동 커밋 중지(디폴트값은 true이기때문에 무조건 커밋된다)
			conn.setAutoCommit(false);
			
			// 콘솔에 입력받는것은 전부 문자형으로 받기때문에
			InputStreamReader isr = new InputStreamReader(System.in);
			// 한줄씩 읽기위한 객체
			BufferedReader br = new BufferedReader(isr);
			
			do {
				System.out.print("이름=");
				String username = br.readLine();
				System.out.print("연락처=");
				String tel = br.readLine();
				System.out.print("이메일=");
				String email = br.readLine();
				System.out.print("주소=");
				String addr = br.readLine();
				//3. PreparedStatement 생성
				String sql = "insert into member(num, username, tel, email, addr, writedate)"
						+ " values(memsq.nextval,?,?,?,?,sysdate)"; // 값이 정해지지 않은경우 ?를 사용
				// 쿼리문을 문자열로 만들어둔것을 Connection 객체에 담아두는 객체 생성
				PreparedStatement pstmt= conn.prepareStatement(sql);
				// ?에 값을 셋팅 (첫번째 물음표에 username 셋팅) / int형이 있을경우 setint로한다.
				pstmt.setString(1, username);
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4. 실행
				int result = pstmt.executeUpdate();
				
//				sql = "insert into member(num, username, tel, email, addr, writedate)" 
//					  + "values(memsq.nextval,?,?,?,?,sysdate)";
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setString(1, "AAAAA");
//				pstmt.setString(2, "010-8989-7878");
//				pstmt.setString(3, "abcabc@naver.com");
//				pstmt.setString(4, "서울시 강서구");
//				
//				int result2 = pstmt.executeUpdate();
				//result에 값이 있고, result2에 값이 있으면..
				if(result > 0 /*&& result2 > 0 */) {
					conn.commit();
					System.out.println("회원등록되었습니다.");
				}
			}while(true);
			
			
		}catch(Exception e) {
			//예외발생하면 먼저 정상실행된 쿼리실행문 취소
			try {
				//예외가 발생하면 지정했던 경로에 있는 계정 롤백
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new InsertTest();
	}

}
