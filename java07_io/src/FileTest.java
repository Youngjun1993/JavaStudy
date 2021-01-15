import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		//현재 주소에서부터 찾아가는걸 상대주소 / 현재 어디에 잇든 상관없이 찾아가는걸 절대주소 라고 한다.
		//윈도우는 \로 경로를 구분하지만 자바는 /로 구분한다.
		//폴더 경로는 없는 경로를 설정할경우 해당 폴더명을 가진 폴더가 생성된다.
		//File객체 생성 : 드라이브명, 폴더명, 파일명 반드시 절대 주소
		File f1 = new File("d://javaIO");
		File f2 = new File("d://javaFileTest/test1.sql");
		File f3 = new File(f1,"test.txt");
		
		//폴더생성하기
		// exists() : 폴더 또는 파일이 존재하는지 여부를 확인(true : 있다, false : 없다)
		// mkdirs() : 폴더 여러개 생성 ex) File("d://a/b")
		// mkdir() : 단일 폴더 생성 ex) File("d://a") 인데 굳이 선언 안해도 되고 mkdirs도 단일 폴더 생성이 가능하기에 mkdirs를 사용한다.
		if(!f1.exists()) {//폴더가 없으면
			if(f1.mkdirs()) {
				System.out.println("폴더가 생성되었습니다.");
			}else {
				System.out.println("폴더가 생성되지 않았습니다.");
			}
		}
		//파일 생성
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {
					System.out.println("파일이 생성되었습니다.");
				}else {
					System.out.println("파일이 생성되지 않았습니다.");
				}
			}catch(IOException e) {
				System.out.println("파일생성에러 발생--->"+e.getMessage());
			}
		}
		//마지막 수정일 얻어오기
		long lastDate = f2.lastModified(); //밀리초로 구해준다.
		System.out.println("lastDate="+lastDate);
		
		//밀리초를 날짜로 변환
		Calendar now = Calendar.getInstance(); //현재...
		now.setTimeInMillis(lastDate);//밀리초를 Calendar 셋팅
		//2021-01-12 오후 03-01
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		String lastDateStr = format.format(now.getTime());
		System.out.println("lastDateStr=" + lastDateStr);
		
		//
		System.out.println("canExcute="+f2.canExecute());		// 실행가능여부
		System.out.println("canRead="+f2.canRead());			// 읽기여부
		System.out.println("canWrite="+f2.canWrite());			// 쓰기여부
		System.out.println("isFile="+f2.isFile());				// 파일인지 황긴
		System.out.println("isDirectory="+f2.isDirectory());	// 디렉토리인지 확인
		System.out.println("-------------------------------------");
		
		// 특정드라이브 또는 특정폴더의 폴더목록, 파일목록을 구한다.
		File f4 = new File("C://");
		File file[] = f4.listFiles(); // 경로에 들어가있는 폴더 및 파일들을 배열화
		// getPath() : 드라이브명, 파일명, 경로를 리턴한다.
		// getName() : 파일명 리턴
		// getAbsoluteName() :드라이브명,파일명, 경로 리턴 (getPath와 같다)
		// getParent() : 드라이브명, 경로 리턴
		
		for(File f : file) {
			if(f.isDirectory()) {
				// 숨김파일 여부
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨김폴더]");
				}else {
					System.out.println(f.getPath()+"[폴더]");
				}
			}else if(f.isFile()){
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨김파일]");
				}
				else {
					System.out.println(f.getPath()+"[파일]");
				}
			}
		}
		System.out.println("-------------------------------------");
		//현재컴퓨터의 드라이브목록
		File drive[] =File.listRoots();
		for(File f : drive){
			System.out.println(f.getPath());
		}
		//파일크기(byte)
		long size = f2.length();
		System.out.println("file size ->" + size + "byte");
		
		//파일삭제
		f3.delete();
		System.out.println("파일이 삭제됨..");
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
