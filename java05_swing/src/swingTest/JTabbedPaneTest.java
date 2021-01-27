package swingTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp = new JTabbedPane();
	
	ImageIcon ii1 = new ImageIcon("img/back.jpg");
	ImageIcon ii2 = new ImageIcon("icon/save01.gif");
	
	JLabel lbl = new JLabel(ii1);
	
	Calculator cal = new Calculator();
	CalendarSwing calendar = new CalendarSwing();
	DigitalClock clock = new DigitalClock();
	PackMan packMan = new PackMan();
	
	public JTabbedPaneTest() {
		add(tp);
		
		//탭패널에 컴퍼넌트 추가
		tp.addTab("하우스", lbl);
		
		//계산기
		//		  title, 아이콘, 컴포넌트, 계산기
		tp.addTab("계산기", ii2, cal, "Calcurator");
		
		//달력
		tp.addTab("달력", calendar);
		
		//시계
		tp.addTab("시계", clock);
		
		//팩맨
		tp.addTab("팩맨", packMan);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//시계 스레드 시작
		Thread clockThread = new Thread(clock);
		clockThread.start();
		
		//팩맨 스레드 시작
		//캔버스 크기 다시 셋팅(프레임 크기가 달라젔다)
		packMan.getPackManSize();
		Thread packThread = new Thread(packMan);
		packThread.start();
		
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//중간에 tabMenu추가 하기
		tp.insertTab("버튼", ii2, new JButton("버튼"), "Tabbed테스트 중", 2);
	
		//활성화 비활성화하기
		// true : 활성화, false : 비활성화(모두 비활성화 된다.)
		//tp.setEnabled(false);
	
		tp.setEnabledAt(2, false);
		
		//탭메뉴 삭제
		//tp.removeTabAt(3);
		
		//탭메뉴 위치 이동
		tp.setTabPlacement(JTabbedPane.LEFT);
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
