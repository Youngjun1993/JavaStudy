import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	//1. 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("드라이브로딩 실패==>"+e.getMessage());
		}
	}
	//DB연결 클래스
	Connection conn = null;
	//DB핸들링 클래스
	PreparedStatement pstmt = null;
	//select문 사용 클래스
	ResultSet rs = null;
	
	String sql = null;
	String url = "jdbc:oracle:thin:@192.168.0.32:1521:xe";
	String userId = "c##scott";
	String userPwd = "tiger";
	
	public DBConn() {
		
	}
	//DB 연결 메소드
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url,userId,userPwd);
		}catch(Exception e) {
			System.out.println("DB연결 에러 ==>"+e.getMessage());
		}
	}
	//DB 접속종료 메소드
	public void DBClose() {
		try {
			// 먼저 끝나는 순서대로 close 선언.
			// 초기값이 null이기때문에 if문 사용하여 close선언
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) { // close exception 처리
			System.out.println("DB종료 에러발생 ==>"+e.getMessage());
		}
	}
}
