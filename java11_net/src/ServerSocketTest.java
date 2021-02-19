import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
// 서버
public class ServerSocketTest {

	public ServerSocketTest() {
		try {
			ServerSocket ss = new ServerSocket(12000);
			//클라이언트가 접속할때까지 대기하고 있다.
			//클라이언트가 접속을하면 Socket객체를 리턴해준다.
			//while(true) { //클라이언트 다수 받기
				System.out.println("접속 대기중....");
				Socket s = ss.accept();
				
				System.out.println("클라이언트가 접속하였습니다...");
				//클라이언트가 접속하면 접속자의 컴퓨터 ip를 inetaddress객체로 가진다.
				InetAddress ia = s.getInetAddress();
				System.out.println(ia.getAddress() + "/" + ia.getHostAddress());
				//접속자에게 서버가 문자 보내기..
				OutputStream os = s.getOutputStream(); //byte로 쓰기
				//byte를 char로 변경하여 쓰기
				OutputStreamWriter osw = new OutputStreamWriter(os);
				
				//println을 쓰기위한 쓰기 객체
				PrintWriter pw = new PrintWriter(osw);
				pw.println("안녕...난 서버야...");
				pw.flush(); // 네트워크를 통해 넘어가는 시점 정의 (보내기)
				//pw.close();
				System.out.println("클라이언트에게 문자를 보냈습니다...");
				
				//클라이언트가 보낸 문자 받기
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String data = br.readLine();
				System.out.println("클라이언트가 보낸 문자-->"+data);
				br.close();
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerSocketTest();
	}

}
