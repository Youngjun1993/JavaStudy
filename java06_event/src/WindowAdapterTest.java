import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//Adapter 상속
//JFrame, WindowAdapter 중 골라서 상속받아야 한다.
public class WindowAdapterTest extends WindowAdapter{
	JFrame frm = new JFrame("WindowAdapter 테스트");
	public WindowAdapterTest() {
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
		//frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
	
		frm.addWindowListener(this);
	}
	//재 오버라이딩 -> windowAdapter를 상속받기때문에 해당 메소드만 쏙 빼와서 사용이 가능한것
	public void windowClosing(WindowEvent we) {
		System.out.println("윈도우 이벤트 발생");
		frm.dispose();//자원해제
		System.exit(0);
	}
	public static void main(String[] args) {
		new WindowAdapterTest();
	}

}
