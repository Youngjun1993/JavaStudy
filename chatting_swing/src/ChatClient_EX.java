//이영준
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//								 JFrame상속			이벤트리스너, Thread 추상 클래스 상속
public class ChatClient_EX extends JFrame implements ActionListener, Runnable{
	//JFrame-center
	JPanel centerPane = new JPanel(new BorderLayout());		// 프레임 중앙에 들어갈 패널(보더레이아웃)
		JPanel connPane = new JPanel(new BorderLayout());	// 중앙 패널에 들어갈 패널(보더레이아웃)
			JTextField connTf = new JTextField();			// 왼쪽 패널에 들어갈 텍스트 필드
			JButton connBtn = new JButton("접속");			// 왼쪽 패널에 들어갈 버튼
		JTextArea msgTa = new JTextArea();					// 중앙 패널에 들어갈 텍스트에어리어
		JScrollPane msgSp = new JScrollPane(msgTa);			// 중앙 패널에 들어갈 스크롤패널(텍스트에어리어)
		JPanel sendPane = new JPanel(new BorderLayout());	// 중앙 패널에 들어갈 보내기 패널
			JTextField sendTf = new JTextField();			// 보내기 패널에 들어갈 텍스트 필드
			JButton sendBtn = new JButton("보내기");			// 보내기 패널에 들어갈 버튼
	//JFrame-East
	JPanel eastPane = new JPanel(new BorderLayout());								// 프레임 오른쪽에 들어갈 패널(보더레이아웃)
		JLabel listTitle = new JLabel("              접속자리스트            ");		// 패널에 들어갈 상단 라벨
		DefaultListModel<String> nameModel = new DefaultListModel<String>();		// List에 넣을 model<String> 생성
		JList<String> nameList = new JList<String>(nameModel);						// model을 담을 List컬렉션 생성
		JScrollPane nameListSp = new JScrollPane(nameList);							// List를 담는 스크롤 패널 생성
		JLabel connCountLbl = new JLabel("현재원 : 0명");								// 패널에 들어갈 하단 라벨
		
	Socket s;				// 소켓 생성
	PrintWriter pw;			// writer 생성
	BufferedReader br;		// reader 생성
	
	public ChatClient_EX() {
		//JFrame-center
		//프레임 레이아웃 설정 작업
		add(centerPane);
		centerPane.add("North", connPane);
			connPane.add(connTf);
			connPane.add("East",connBtn);
		centerPane.add(msgSp);
			msgTa.setBackground(Color.LIGHT_GRAY);
		centerPane.add("South", sendPane);
			sendPane.add(sendTf);
			sendPane.add("East", sendBtn);
		
		//JFrame-East
		//프레임 레이아웃 설정 작업
		add("East", eastPane);
			eastPane.add("North",listTitle);
			nameModel.addElement("");
			eastPane.add(nameListSp);
			eastPane.add("South", connCountLbl);
		
		//프레임 기본 셋팅
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	//이벤트 추상 클래스 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		Object eObj = ae.getSource();//오브젝트에 발생한 이벤트 오브젝트를 담는다.
		if(eObj == connTf || eObj == connBtn) {
			//서버연결
			serverConnection();
		}else if(eObj == sendTf || eObj == sendBtn) {
			//문자보내기
			if(sendTf.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "메세지를 입력 후 보내기를 선택하세요.");//sendTf에 텍스트가 공백이라면 프레임에 메세지 다이어로그 출력
			}else {
				pw.println(sendTf.getText());//printwirter에 sendTf에 입력된 텍스트를 가져와 출력한다.
				pw.flush();					//데이터 내보내기
				sendTf.setText("");			//텍스트필드 공백처리
			}
		}
	}
	//통신 메소드
	public void serverConnection() {
		if(connTf.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "ip를 입력 후 접속하세요.");
		}else {
			try {
				InetAddress ia = InetAddress.getByName(connTf.getText());//호스트주소(iP)를 입력받아 InetAddress에 대입한다.
				s = new Socket(ia,15000);//소켓을 생성한다(호스트주소(ip), 포트번호)
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));//버퍼리더에 소켓에 입력된 호스트주소와 포트번호를 기준으로 읽기 스트림을 생성한다.
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));//프린트라이터에 소켓에 입력된 호스트주소와 포트번호를 기준으로 쓰기 스트림을 생성한다.
				
				//이미 연결되면 다시 접속못하도록 접속을 비활성화
				connTf.setEnabled(false);
				connBtn.setEnabled(false);
				
				Thread t = new Thread(this); //현재 클래스를 스레드로 생성
				t.start();//스레드 시작
				
			}catch(Exception e) {
				
			}
		}
	}
	// 동기화(동시접속되는것을 막는다) 멀티 스레드 오버라이딩
	public synchronized void run() {
		while(true) {
			try {
				String inData = br.readLine();	//inData 변수에 버퍼리더 스트림에 담아있는 데이터를 한라인씩 꺼내읽어 대입한다.
				if(inData != null) {//inData 변수에 대입된 데이터가 없지 않다면(있다면)
					String header = inData.substring(0,6);// header에 inData에 있는 index 0번부터 6번까지 문자열을 담는다.
					if(header.equals("$$NG##")) {//접속자정보알림
						msgTa.append(inData.substring(6)+"\n");//6번쨰 index부터 끝까지
					}else if(header.equals("!&CN!&")) {//인원수
						connCountLbl.setText("현재원 : "+inData.substring(6) +"명");
					}else if(header.equals("@@Cl$%")) {//접속자목록
						//192.168.55.126/192.168.5.4/와 같이 목록출력
						setConnectionListReset(inData.substring(6));
					}else if(header.equals("$#MG^%")) {
						msgTa.append(inData.substring(6)+"\n");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//inData의 앞 6글자 이후 모든 글자를 매개변수로 받는 리스트리셋 메소드 생성
	public void setConnectionListReset(String nameList) {
		StringTokenizer st = new StringTokenizer(nameList, "/"); // 매개변수의 "/"를 구분값으로 담는 토큰을 생성한다.
		nameModel.removeAllElements();//기존 목록 제거
		while(st.hasMoreTokens()) { //다음 토큰이 있는지 확인(true)하여 없을때까지 반복
			nameModel.addElement(st.nextToken()); //nameModel(List에 담을 데이터)에 토큰을 객체로 추가한다.
		}
	}
	public static void main(String[] args) {
		new ChatClient_EX();
	}

}
