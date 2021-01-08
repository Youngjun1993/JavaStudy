import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		super("Swing 테스트중");
		
		JButton btn = new JButton("swing버튼");
		add(BorderLayout.NORTH, btn);
		
		//테두리가 없는 컨테이너 : JPanel -> default : FlowLayout
		JPanel pane = new JPanel();
		// GridLayout : 바둑판식 레이아웃
		//							row, col, hgap, vgap
		//							row:고정적, col:유동적
		pane.setLayout(new GridLayout(0,2,20,20));
		
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		JButton btn6 = new JButton("버튼6");
		
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		
		add(BorderLayout.CENTER, pane);
		
		setSize(500,500);
		setVisible(true);
		
		//프로그램 종료시 자원해제시키는 설정
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
