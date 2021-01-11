import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{
	JPanel pane = new JPanel();
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JButton btn = new JButton("보내기");
	JTextField tf = new JTextField(20);
	
	Font fnt = new Font("궁서체",Font.BOLD,15);
	public KeyEventTest() {
		super("key이벤트"); // JFrame 생성자 메소드 호출
	
		add(sp);
		add(BorderLayout.SOUTH, pane);
		pane.add(tf);
		pane.add(btn);
		
		//ta에 Font객체 세팅
		ta.setFont(fnt);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트등록
		tf.addKeyListener(this);
		
		// 현재 클래스에 액션실행 메소드가 없고 SenButton클래스에 메소드가 실현되어있기에 객체생성
		// 액션 실행 메소드 = actionPerfomed();
		btn.addActionListener(new SendButton(ta, tf));
	}
	@Override
	public void keyTyped(KeyEvent e) { // 키를 누른 후 놓으면 실행
		
	}
	@Override
	public void keyPressed(KeyEvent e) { // 키를 누른상태에서 실행
		
	}
	@Override
	public void keyReleased(KeyEvent e) { // 키를 누른 후 놓으면 실행
		//이벤트가 발생한 키정보얻어오기
		char evtChar = e.getKeyChar();
		int evtInt = e.getKeyCode();
		System.out.println(evtChar+"->"+evtInt);
		// 입력된 값이 엔터값이라면
		if(evtInt == KeyEvent.VK_ENTER) {
			ta.append(tf.getText()+"\n");
			tf.setText(""); //문자 지우기
		// 입력된 값이 esc키라면
		}else if(evtInt == KeyEvent.VK_ESCAPE) {
			System.exit(0); // 프로그램 종료
		}
	}
	public static void main(String[] args) {
		new KeyEventTest();
	}

}
