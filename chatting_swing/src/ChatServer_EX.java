//이영준
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer_EX extends Thread{
	//접속대기 객체
	ServerSocket ss;
	//접속자(Socket)들 보관할 객체
	List<ChatService> connAll= new ArrayList<ChatService>(); //내부 클래스인 ChatService를 제네릭으로 받는 List콜렉션 생성
	public ChatServer_EX() {
		this.start();	// Thread를 상속받고있기 때문에 바로 현재 클래스를 시작시킨다. 
	}
	//접속대기 스레드
	public void run() {
		try {
			//				임의의 포트번호를 정한다.
			ss = new ServerSocket(15000);
			
			//다음 접속자 대기를 위한 반복문
			while(true) {
				System.out.println("서버 접속대기중....");
				//접속하면 소켓 객체생성 =	 접속할때까지 대기
				Socket s = ss.accept();
				
				//클라이언트가 접속을 하면
				ChatService cs = new ChatService(s); //접속정보를 담은 소켓을 내부클래스 객체에 대입한다.
				System.out.println(cs.userid+"가 접속하였습니다.");
				
				//이미 접속자인지 확인
				connectionCheck(cs);
				
				//모든 접속자 리스트에 추가
				connAll.add(cs);
				
				//현재 접속중인 접속자에 접속을 알린다.
				setMessageAll("$$NG##"+cs.userid+"님이 접속하였습니다.");
				//접속자수 보내기
				setMessageAll("!&CN!&"+connAll.size());
				//접속자 목록 출력
				connectionList();
				
				//클라이언트에 보낸문자를 받아낼 inputStream 스레드 시작
				cs.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//이미 접속자 확인 메소드
	public void connectionCheck(ChatService cs) { //내부클래스인 ChatService를 매개변수로 받는 메소드
		for(int i=0; i<connAll.size(); i++) {	  // List 콜렉션인 connAll 사이즈 만큼 반복
			ChatService service = connAll.get(i); // ChatService타입인 service변수에 List콜렉션에 있는 index i번째 값을 대입
			if(service.userid.equals(cs.userid)) { //이미 접속자일 경우, service에 있는 멤버변수 userid에 값이 cs에있는 userid와 같다면
				connAll.remove(i);//List콜렉션에 index i번째에 있는 값(접속자)을 없앤다.
				break;
			}
		}
	}
	//접속자 목록
	public void connectionList() {
		String idList = "@@Cl$%";	//접속자 목록을 체크하기 위한 6문자 변수설정
		for(int i=0; i<connAll.size(); i++) { 
			ChatService cs = connAll.get(i);
			idList += "/"+cs.userid; //idList변수에 '/'(토큰처리를위한 구분값)을 추가하고 cs에 있는 호스트주소를 추가하여 하나의 문자열을 만든다.
		}
		setMessageAll(idList); //합처진 문자열을 메소드 매개변수로 대입
	}
	//전체 회원에게 메세지 보내기
	public void setMessageAll(String msg) { //문자열을 매개변수로 받아온다
		for(int i=0; i<connAll.size(); i++) {
			try {
				ChatService cs = connAll.get(i);
				//쓰기
				cs.pw.println(msg); //화면에 매개변수로 받은 문자열을 내보낸다.
				cs.pw.flush();	//내보내기
			}catch(Exception e){
				//쓰기중 에러가 생기면 1번째거를 지우고
				connAll.remove(i);
				//0번으로 만들어 2번째꺼를 1번째로 만들어 계속 실행되게끔한다.
				i--;
			}
		}
	}
	//클라이언트가 접속을 하면 접속자 정보를 가질 객체
	class ChatService extends Thread{
		//socket, inputStream, outputStream, 접속자이름(ip)
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		String userid;
		InetAddress ia;
		
		ChatService(){}
		ChatService(Socket s){ //소켓을 매개변수로 받는 생성자 메소드
			try {
				this.s = s;
				//클라이언트에게 받은 문자를 입력받는 객체
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//클라이언트에게 보낼 문자를 출력하는 객체
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
				//소켓에 접속한 접속자 ip구하기
				ia = s.getInetAddress(); //소켓에 정보를 InetAddress로 받는다.
				userid = ia.getHostAddress(); //InetAddress의 ip주소를 userid로 대입
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//입력대기 Thread
		//스레드 오버라이딩
		public void run() { 
			while(true) {
				try {
					String inData = br.readLine(); //소켓정보를 읽은 버퍼리더의 한라인을 대입한다
					if(inData!=null) {
						//접속한 모든 접속자에게 문자 보내기
						setMessageAll("$#MG^%"+userid+"님 :"+inData);
					}
				}catch(Exception e) {
					
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new ChatServer_EX();
	}

}
