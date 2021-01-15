import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
			//콘솔에서 문자단위 입력하는 클래스
			InputStreamReader isr = new InputStreamReader(System.in);
			
			System.out.print("문자입력=");
			while(true){
				/*
				//한번에 1문자(char)를 읽어온다.
				int inData = isr.read();
				// read() : 읽을 데이터가 없을때 -1 리턴됨
				if(inData==-1)break;
				System.out.println(inData +"-->"+(char)inData);
				*/
				// char 배열을 이용하여 여러문자를 한번에 읽어오기
				char[] inData = new char[30];
				// 읽은 문자의 수
				int cnt = isr.read(inData);
				// 문자열로 변환시키기
				String inStr1 = new String(inData,0,cnt);
				String inStr2 = String.valueOf(inData,0,cnt);
				System.out.println(inStr1+"====");
				System.out.println(inStr2+"----");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();
	}

}
