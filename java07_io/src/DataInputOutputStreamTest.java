import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		try {
			//원래 데이터타입으로 저장하기, 불러오기
			//DataOutputStream, DataInputStream
			File file = new File("D://io","data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			//byte:1byte, short:2byte, int:4byte, long:8byte
			//float:4byte, double:8byte
			//char:2byte(unicode):어떨땐 1바이트 어떨땐 2바이트라 통상 2바이트라고 말한다.
			//boolean:1byte
			
			int num = 125487;
			char str = 'Z';
			double num2 = 254836.3254;
			boolean boo = true;
			
			dos.writeInt(num);
			dos.writeChar(str);
			dos.writeDouble(num2);
			dos.writeBoolean(boo);
			dos.close();
			
			//data.txt에 저장하는것은 저장한 데이터형을 얻어야 원하는 정보를 얻어올 수 있다.
			//읽어오기
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			int numIn = dis.readInt();
			char charIn = dis.readChar();
			double num2In = dis.readDouble();
			boolean booIn = dis.readBoolean();
			
			System.out.println("numIn="+numIn);
			System.out.println("charIn="+charIn);
			System.out.println("num2In="+num2In);
			System.out.println("booIn="+booIn);
			
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException ie) {
			System.out.println("쓰기 에러가 발생하였습니다.");
		}
	}

	public static void main(String[] args) {
		new DataInputOutputStreamTest();
	}

}
