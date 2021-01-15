import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		try {
			//한줄단위로 입력할 수 있는 메소드
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("문자열입력=");
			
			//null일 경우 읽어온 데이터가 없다.
			String inData = br.readLine();
			System.out.println("inData="+inData);
		
		}catch(IOException e) {
			e.getStackTrace();
		}
	}
	public static void main(String[] args) {
		new BufferedReaderTest();
	}

}
