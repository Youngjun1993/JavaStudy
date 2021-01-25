
public class UpdateTest extends DBConn{

	public UpdateTest() {}
	public void setUpdate() {
		try {
			//DBConn클래스의 DB연결메소드
			getConn();
			//DBConn클래스의 멤버변수
			sql = "update member set tel=? where username=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "010-555-5555");
			//보통은 primerykey 즉 시퀀스값을 넣지만 지금은 테스트기때문에 이름 사용
			pstmt.setString(2, "이영준");
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"개의 레코드가 수정되었습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//DB종료 메소드는 예외처리로인해 finally안에 선언해줌으로써 무조건 실행되게 한다.
			DBClose();
		}
	}
	public static void main(String[] args) {
		new UpdateTest().setUpdate();
	}

}
