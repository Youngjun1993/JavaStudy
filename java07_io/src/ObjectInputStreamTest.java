import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			//파일의 객체를 읽어오기
			File f = new File("D://io/Object.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			//첫번째 객체 읽어오기
			ArrayList al = (ArrayList)ois.readObject();
			//두번째 객체 읽어오기
			DataVO vo = (DataVO)ois.readObject();
			
			//--------------------------------------------
			String username = (String)al.get(0);
			Calendar date = (Calendar)al.get(1);
			FileCopy copy = (FileCopy)al.get(2);
			
			System.out.println("arrayList.String="+username); //홍길동
			System.out.println("arrayList.Calendar="+date); //파일저장 시분..10:07
			copy.start();	//filecopy
			System.out.printf("dataVO=%d, %s, %s, %s\n",vo.getNum(), vo.getName(), vo.getTel(), vo.getEmail());
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();
	}

}
