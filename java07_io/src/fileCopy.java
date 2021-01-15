import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileCopy {

	public fileCopy() {
		try {		
			//파일복사
			File srcFile = new File("D://common.jpg");
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

	public static void main(String[] args) {
		new fileCopy();
	}

}
