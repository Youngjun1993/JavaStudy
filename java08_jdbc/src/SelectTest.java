import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SelectTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브로딩 에러발생");
		}
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	//								로컬호스트 선언
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "c##scott";
	String userPwd = "tiger";
	
	public SelectTest() {
		
	}
	public void recordSelect() {
		try {
			conn = DriverManager.getConnection(url,userName,userPwd);
			
			String sql = "select num, username, tel, email, writedate, addr from member"
						 + " order by num asc";
			
			// sql에 ?가 없기때문에 바로 선언
			pstmt = conn.prepareStatement(sql);
			// select문 실행
			ResultSet rs = pstmt.executeQuery();
			//rs객체에서 point이동하여 레코드의 정보를 얻어온다.
			while(rs.next()) {
				//데이터 타입으로 가져온다.
				int num = rs.getInt(1); //rs.getInt("num")과 같은 결과를 리턴한다.
				String userName = rs.getString(2); // rs.getString("userName")과 같은 결과를 리턴한다.
				String tel = rs.getString(3);
				String email = rs.getString(4);
				String writedate = rs.getString(5);
				String addr = rs.getString(6);
				System.out.printf("%d, %s, %s, %s, %s, %s\n",num,userName,tel,email,writedate,addr);
			}
			
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new SelectTest().recordSelect();
	}

}
