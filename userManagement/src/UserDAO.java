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

	//회원등록
	public int memberInsert(UserVO vo) {
		int result = 0;
		try {
			getConn();
			
			sql = "insert into member(num, username, tel, addr, email) "
					+" values(memsq.nextval, ?, ?, ?, ?)";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
		return result;
	}
	//회원정보수정				번호, 연락처, 이메일, 주소
	public int memberUpdate(UserVO vo) {
		int result=0;
		try {
			getConn();
			sql = "update member set tel=?, email=?, addr=? where num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTel());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddr());
			pstmt.setInt(4, vo.getNum());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
		return result;
	}
	//회원삭제
	public int memberDelete(int num) {
		int result = 0;
		try {
			getConn();
			sql = "delete from member where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
		return result;
	}
}


















