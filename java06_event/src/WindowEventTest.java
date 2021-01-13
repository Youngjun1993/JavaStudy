import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WindowEventTest extends JFrame implements WindowListener {
	JLabel lbl = new JLabel("계산기");
	Calculator cal = new Calculator();
	
	public WindowEventTest() {
		add("North",lbl);
		add(cal);
		
		setSize(500,300);
		setVisible(true);
		//프로그램 종료시 자원해제
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//창닫기 금지
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
	}
	
		
	public static void main(String[] args) {
		new WindowEventTest();
	}


	@Override
	public void windowOpened(WindowEvent e) {
		//열림
		System.out.println("Opened()");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 해당 클래스는 JFrame을 상속받고 있기 때문에 this 선언
		int state = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?","종료확인",
					JOptionPane.YES_NO_OPTION);
		
		//닫기버튼 누를시
		System.out.println("Closing()");
	
		if(state == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//닫아짐
		System.out.println("Closed()");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		//아이콘화(최소화?)
		System.out.println("Iconified()");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		//아이콘 비활성화
		System.out.println("Deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		//활성화
		System.out.println("Activated()");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		//비활성화
		System.out.println("Deactivated()");
	}
	
}
