import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * 자바에서 excel로 쓰기, 읽기
 * 
 * jakarta.apache.org에서 POI를 다운로드 받는다.
 * poi-5.0.0.jar, commons-math3-3.6.1.jar를
 * buildPath 설정 -> project에서 마우스오른쪽 buildPath선택
 *
 * HSSF가 앞에 붙는 클래스들은 해당 프레임워크 클래스들이다.(import해줘야된다.)
 */
public class WriteExcel {

	public WriteExcel() {
		//엑셀로 쓰기
		//1.  workbook 객체
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//2. sheet객체 생성
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3. row객체 생성
		HSSFRow row1 = sheet1.createRow(0); //매개변수 값은 시작행을 의미한다.
		
		//4. cell객체 생성
		HSSFCell cell1 = row1.createCell(0); //매개변수 값은 시작필드를 의미한다.
		
		//5. value 셋팅
		cell1.setCellValue("번호"); // 1행 1열
		
		row1.createCell(1).setCellValue("이름"); // 1행 2열
		row1.createCell(2).setCellValue("연락처"); // 1행 3열
		row1.createCell(3).setCellValue("이메일"); // 1행 4열
		
		////////////////////////////////////////////////////////
		 String data[][] = {
				 {"1","홍길동","010-1111-1111","aaaaa@nate.com"},
				 {"2","감강찬","010-2222-2222","bbbbb@nate.com"},
				 {"3","세종대왕","010-3333-3333","ccc@nate.com"},
				 {"4","광개토대왕","010-4444-4444","ddddd@nate.com"},
				 {"5","이순신","010-5555-5555","eeee@nate.com"}
		};
		
		for(int r=0; r<data.length; r++) {//1,2,3,4,5 (행의 수)
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length; c++) {//0,1,2,3 (컬럼 수)
				if(c==0) {
					//번호(문자)를 숫자로 변경
					cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c])); // index는 0부터 시작
				}else {
					cRow.createCell(c).setCellValue(data[r][c]);
				}
			}
		}
		// 엑셀파일 생성
		File f = new File("D://io/member.xls");
		
		// File쓰기
		try {
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			workbook.close();
		}catch(IOException e) {
			e.getStackTrace();
		}
		System.out.println("엑셀로 쓰기 완료....");
	}

	public static void main(String[] args) {
		new WriteExcel();
	}

}
