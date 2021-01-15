import java.io.File;
import java.io.FileWriter;

public class FileWriterTest {

	public FileWriterTest() {
		try {
			File f = new File("D://io/testfile.txt");
			FileWriter fw = new FileWriter(f);
			String txt = "자바에서 문자열을 파일로 쓰기 연습중!!!!!\n";
			
			//1. 배열로 저장
			//문자열을 char배열로 생성
			char c[] = txt.toCharArray();
			//인덱스 0부터 c배열의 길이만큼
			fw.write(c, 5, c.length-5);
			//기록명령 메소드
			fw.flush();
			
			//2. 문자열로 쓰기
			fw.write(txt,0,txt.length());
			fw.flush();
			
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("end.....");
	}

	public static void main(String[] args) {
		new FileWriterTest();
	}

}
