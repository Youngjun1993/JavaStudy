import java.sql.CallableStatement;
import java.sql.Types;

public class InsertProcedure extends DBConn{

   public InsertProcedure() {
      try {
         // 연걸
         getConn();
         // callablestatement 프로시저호출
         sql="{call mem_insert(?,?,?,?,?)}";
         // 프로시저 호출시에는 { } 를쓴다요
         CallableStatement cstmt = conn.prepareCall(sql);
         cstmt.setString(1, "Serah"); // 이름
         cstmt.setString(2, "010-5716-9005"); // 연락처
         cstmt.setString(3, "soulmate026@daum.net"); // 이메일
         cstmt.setString(4, "경기도 부천시"); //
         cstmt.registerOutParameter(5, Types.INTEGER); // 프로시저에서 아웃풋으로 가져올 데이터가 있을때 사용하는 메소드
         // 실행
         cstmt.executeUpdate();
         
         if(cstmt.getInt(5)>0) {
        	 System.out.println("회원이 등록되었습니다.");
         }else {
        	 System.out.println("회원등록 실패하였습니다.");
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      } finally {
         DBClose();
      }
   }

   public static void main(String[] args) {
      new InsertProcedure();

   }

}