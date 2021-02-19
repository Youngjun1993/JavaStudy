import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
// 클라이언트
public class SocketTest {
	
	public SocketTest() {
		try {
			//							InetAddress = server의 ip
			InetAddress ia = InetAddress.getByName("192.168.0.32");
			int port = 12000;
			
			//Socket : 서버에 접속하는 객체이다.
			//Socket객체가 생성되면서 서버 ip와 포트번호로 접속을 한다.
			Socket s = new Socket(ia, port);
			
			//서버에서 보낸 데이터 받기
			InputStream is = s.getInputStream(); // byte단위로 읽어온다.
			InputStreamReader isr = new InputStreamReader(is);// byte로 읽어온것을 char단위로 읽어온다.
			BufferedReader br = new BufferedReader(isr);//line으로 읽는다.
			
			String data = br.readLine();
			System.out.println("서버에서 받은 문자-->"+data);
			//br.close();
			
			//클라이언트가 서버로 데이터 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("하이....server!!!!!!!");
			pw.flush();
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SocketTest();
	}
}
