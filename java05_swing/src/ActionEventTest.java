import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ActionEventTest implements ActionListener{
	JFrame frm = new JFrame("ActionEvent");
	JButton btn = new JButton("클릭");
	JButton btn2 = new JButton("3단");
	JTextArea ta = new JTextArea("버튼을 클릭하세요. \n");
	JScrollPane sp = new JScrollPane(ta);	// 스크롤바 생성
	
	
	public ActionEventTest() {
		frm.add(BorderLayout.NORTH, btn);
		frm.add(BorderLayout.SOUTH, btn2);
		frm.add(sp);	// 스크롤바 기능 추가
		
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		// 이벤트 등록
		btn.addActionListener(this); // 현재클래스에서 action event 메소드 실행(오버라이딩됨)
		btn2.addActionListener(this);
	}
	// 추상메소드 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		//setText() : 새로운 문자로 세팅
		//append() : 마지막에 문자 추가
		//insert() : 원하는 위치(index)에 문자 추가
		//ta.append("Click\n");
		
		//1.이벤트가 발생한 버튼 알아내기 -> getActionCommand();
		/*
		String evt = ae.getActionCommand();
		if(evt.equals("클릭")) {
			ta.append(evt+"\n");
		}else if(evt.equals("3단")) {
			gugudan(3);
		}
		*/
		//2.이벤트가 발생한 객체를 이용하여 알아내기
		Object obj = ae.getSource();
		if(obj == btn) {//버튼클릭 선택시
			ta.append("btn버튼 클릭\n");
		}else if(obj == btn2) {
			gugudan(9);
		}
	}
	
	public void gugudan(int dan) {
		for(int i=2; i<10; i++) {
			ta.append(dan + " * " + i + " = " + (dan*i) + "\n");
		}
	}
	
	public static void main(String[] args) {
		new ActionEventTest();
	}

}
