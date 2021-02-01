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


public class ChatServer extends Thread{
	//접속대기 객체
	ServerSocket ss;
	//접속자(Socket)들 보관할 객체
	List<ChatService> connAll= new ArrayList<ChatService>();
	public ChatServer() {
		this.start();
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
				ChatService cs = new ChatService(s);
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
	public void connectionCheck(ChatService cs) {
		for(int i=0; i<connAll.size(); i++) {
			ChatService service = connAll.get(i);
			if(service.userid.equals(cs.userid)) { //이미 접속자일 경우
				connAll.remove(i);
				break;
			}
		}
	}
	//접속자 목록 보내기
	public void connectionList() {
		String idList = "@@Cl$%";
		for(int i=0; i<connAll.size(); i++) {
			ChatService cs = connAll.get(i);
			idList += "/"+cs.userid;
		}
		setMessageAll(idList);
	}
	//전체 회원에게 메세지 보내기
	public void setMessageAll(String msg) {
		for(int i=0; i<connAll.size(); i++) {
			try {
				ChatService cs = connAll.get(i);
				//쓰기
				cs.pw.println(msg);
				cs.pw.flush();
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
		ChatService(Socket s){
			try {
				this.s = s;
				//클라이언트에게 받은 문자를 입력받는 객체
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//클라이언트에게 보낼 문자를 출력하는 객체
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
				//소켓에 접속한 접속자 ip구하기
				ia = s.getInetAddress();
				userid = ia.getHostAddress();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//입력대기 Thread
		public void run() {
			while(true) {
				try {
					String inData = br.readLine();
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
		new ChatServer();
	}

}
