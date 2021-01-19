import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
//직렬화를 하여 객체를 파일로 저장하도록 한다.(serializable 상속)
public class FileCopy implements Serializable{

	public FileCopy() {
	}
	public void start() {
		try {		
			//파일복사
			File srcFile = new File("D://실행결과.PNG");
			File tarFile = new File("D://io", srcFile.getName());
			
			FileInputStream fi = new FileInputStream(srcFile);
			FileOutputStream fo = new FileOutputStream(tarFile);
			
			while(true) {
				// 한바이트를 읽는다.
				int inData = fi.read();
				// 읽을 데이터가 없을시 -1이 리턴된다.
				if(inData == -1)break;
				fo.write(inData);
			}
			fo.flush();
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		new fileCopy();
//	}

}
