import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {

	public InsertTest() {
		try {
			//1. jdbc 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB 연결					Url , 계정명, 계정비밀번호
			String url = "jdbc:oracle:thin:@192.168.55.126:1521:xe";
			String userid = "c##scott";
			String userpwd = "tiger";
			Connection conn = DriverManager.getConnection(url, userid, userpwd);
			
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
				if(result > 0) {
					System.out.println("회원등록되었습니다.");
				}else {
					System.out.println("회원등록 실패하였습니다.");
				}
			}while(true);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new InsertTest();
	}

}
