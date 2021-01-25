import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBConn {

	public UserDAO() {
	}
	//레코드 전체선택
	public List<UserVO> memberAllSelect() {
		//선택한 레코드를 보관할 컬렉션
		List<UserVO> lst = new ArrayList<UserVO>();
		try {
			getConn();
			
			sql = "select num, username, tel, email, addr, writedate from member order by num asc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//레코드를 VO 담고 VO를 List에 담고
				UserVO vo = new UserVO(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6));
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
		return lst;
	}
	//레코드추가
	//레코드수정
	//레코드삭제
	//레코드검색
	public List<UserVO> getSearchRecord(String searchWord){
		List<UserVO> lst = new ArrayList<UserVO>();
		try {
			getConn();
			sql = "select num, username, tel, email, addr, writedate "
			+" from member where username like ? or tel like ? order by num asc";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setString(2, "010-%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setNum(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWritedate(rs.getString(6));
			
				lst.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
		return lst;
	}

}
