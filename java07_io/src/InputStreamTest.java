import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		/*
		int a[] = new int[10];
		for(int b : a) {
			System.out.println(b);
		}
		*/
		try {
			// InputStream은 추상클래스로 객체 생성 불가하다.
			// InputStream은 byte단위로 입력받는 클래스
			InputStream is = System.in;
			System.out.print("입력=");
			
			// read() -> 입력문자를 1byte씩 읽어온다./ Enter : 2바이트를 차지한다.
			while(true) {
				/* 
			 	read()로 한byte 읽기
			 	int inData = is.read(); // 읽을 데이터가 없을때 -1입력
				if(inData == -1) break;
				System.out.println(inData+","+(char)inData);
				*/
				/*
				//reat(a[]) : 배열크기 만큼 한번에 읽어온다.
				byte inData[] = new byte[50];
				//	byte수	   읽은 byte는 배열에 저장
				int cnt = is.read(inData);
				//						0번째 인덱스부터 배열수까지 문자화
				System.out.println(new String(inData,0,cnt)+"-->"+cnt);
				if(cnt<=0) break;
				*/
				//	 읽은데이터 담을 배열, 배열의 저장위치 index, 읽어올 byte갯수
				//read(arr[], int, int)
				byte inData[] = new byte[10];
				int cnt = is.read(inData, 3, 4);
				for(int i=0; i<inData.length; i++) {
					System.out.println("inData["+i+"]="+inData[i]);
				}
			}
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	public static void main(String ar[]) {
		new InputStreamTest();
	}
}
