import java.sql.CallableStatement;

public class UpdateProcedure extends DBConn{

   public UpdateProcedure() {
      // 이름을 입력받아 연락처, 이메일, 주소를 수정
      try {
         getConn();
         
         sql= "{call mem_update(?,?,?,?)}";
         
         CallableStatement cstmt = conn.prepareCall(sql);
         cstmt.setString(1, "010-9913-3500");
         cstmt.setString(2, "leculo@gmail.com");
         cstmt.setString(3, "서울시 마포구");
         cstmt.setString(4, "홍길동");
         
         int r = cstmt.executeUpdate();
         
         if(r>0) {
            System.out.println("회원정보 수정이 완료되었습니다.");
         } else {
            System.out.println("회원정보 수정에 실패하였습니다.");
         }
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         DBClose();
      }
   }

   public static void main(String[] args) {
      new UpdateProcedure();

   }

}