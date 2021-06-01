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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//이영준

public class ChatClient extends JFrame implements ActionListener, Runnable{
	//JFrame-center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel connPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField();
			JButton connBtn = new JButton("접속");
		JTextArea msgTa = new JTextArea();
		JScrollPane msgSp = new JScrollPane(msgTa);
		JPanel sendPane = new JPanel(new BorderLayout());
			JTextField sendTf = new JTextField();
			JButton sendBtn = new JButton("보내기");
	//JFrame-East
	JPanel eastPane = new JPanel(new BorderLayout());
		JLabel listTitle = new JLabel("              접속자리스트            ");
		DefaultListModel<String> nameModel = new DefaultListModel<String>();
		JList<String> nameList = new JList<String>(nameModel);
		JScrollPane nameListSp = new JScrollPane(nameList);
		JLabel connCountLbl = new JLabel("현재원 : 0명");
		
	Socket s;
	PrintWriter pw;
	BufferedReader br;
	
	public ChatClient() {
		//JFrame-center
		add(centerPane);
		centerPane.add("North", connPane);
			connPane.add(connTf);
			connPane.add("East",connBtn);
		centerPane.add(msgSp);
			msgTa.setBackground(Color.LIGHT_GRAY);
		centerPane.add("South", sendPane);
			sendPane.add(sendTf);
			sendPane.add("East", sendBtn);
		
		///////Border ///////////////////
		LineBorder lineBorder = new LineBorder(Color.GREEN);
		TitledBorder tBorder = new TitledBorder(lineBorder, "Message", TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
		
		centerPane.setBorder(tBorder);
		/////////////////////////////////
			
		//JFrame-East
		add("East", eastPane);
			eastPane.add("North",listTitle);
			nameModel.addElement("");
			eastPane.add(nameListSp);
			eastPane.add("South", connCountLbl);
		
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object eObj = ae.getSource();
		if(eObj == connTf || eObj == connBtn) {
			//서버연결
			serverConnection();
		}else if(eObj == sendTf || eObj == sendBtn) {
			//문자보내기
			if(sendTf.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "메세지를 입력 후 보내기를 선택하세요.");
			}else {
				pw.println(sendTf.getText());
				pw.flush();
				sendTf.setText("");
			}
		}
	}
	//통신 메소드
	public void serverConnection() {
		if(connTf.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "ip를 입력 후 접속하세요.");
		}else {
			try {
				InetAddress ia = InetAddress.getByName(connTf.getText());
				s = new Socket(ia,15000);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
				//이미 연결되면 다시 접속못하도록 접속을 비활성화
				connTf.setEnabled(false);
				connBtn.setEnabled(false);
				
				Thread t = new Thread(this);
				t.start();
				
			}catch(Exception e) {
				
			}
		}
	}
	public synchronized void run() {
		while(true) {
			try {
				String inData = br.readLine();
				if(inData != null) {
					String header = inData.substring(0,6);
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
	public void setConnectionListReset(String nameList) {
		StringTokenizer st = new StringTokenizer(nameList, "/");
		nameModel.removeAllElements();//기존 목록 제거
		while(st.hasMoreTokens()) {
			nameModel.addElement(st.nextToken());
		}
	}
	public static void main(String[] args) {
		new ChatClient();
	}

}
