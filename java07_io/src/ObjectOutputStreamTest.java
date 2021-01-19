import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		//ObjectOutputStream : 객체를 파일로 쓰기를 할 수 있다.
		//					   객체를 직렬화하여야 한다.
		
		Calendar now = Calendar.getInstance();
		FileCopy fc = new FileCopy();
		
		ArrayList lst = new ArrayList();
		lst.add(new String("홍길동"));
		lst.add(now);
		lst.add(fc);
		
		DataVO vo = new DataVO();
		vo.setNum(1234);
		vo.setName("세종대왕");
		vo.setTel("010-1111-2222");
		vo.setEmail("zerojunee@naver.com");
		try {
			//객체를 파일로 쓰기
			File f = new File("D://io/Object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//두개의 객체 저장(쓰기)
			oos.writeObject(lst);
			oos.writeObject(vo);
			
			oos.flush();
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("객체저장이 완료되었습니다.");
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}

}
