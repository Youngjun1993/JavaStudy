import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame{
	ImageIcon ii1 = new ImageIcon("img/movie01.png");
	ImageIcon ii2 = new ImageIcon("img/movie02.png");
	ImageIcon ii3 = new ImageIcon("img/movie03.png");
	ImageIcon ii4 = new ImageIcon("img/movie04.png");
	ImageIcon ii5 = new ImageIcon("img/movie05.png");
	
	
	public JButtonTest() {
		super("JButton Test");
		
		setLayout(new GridLayout(0,3,10,10));//레이아웃 변경
		
		JButton btn1 = new JButton(ii1);
		add(btn1);
		
		//버튼의 비활성화
		btn1.setEnabled(false); // true : 활성화, false: 비활성화
		
		
		JButton btn2 = new JButton("확인", ii2);
		add(btn2);
		
		//속성 -> 마우스를 올리면 아이콘이 ii3로 변경
		btn2.setRolloverIcon(ii3);
		//마우스 누른상태일때 아이콘 ii4로 변경
		btn2.setPressedIcon(ii4);
		
		//RadioButton만들기
		JPanel pane = new JPanel(new GridLayout(3,1));
		// pane.setLayout(new GridLayout(3,1));
		
		JRadioButton rb1 = new JRadioButton("ONE", false);
		JRadioButton rb2 = new JRadioButton("TWO", false);
		JRadioButton rb3 = new JRadioButton("THREE", false);
		
		//ButtonGroup : radioButton 그룹화
		//객체를 만들어 등록
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1); bg.add(rb2); bg.add(rb3);
		
		pane.add(rb1); pane.add(rb2); pane.add(rb3);
		add(pane);
		
		//ToggleButton
		JToggleButton tb1 = new JToggleButton("토글버튼");
		JToggleButton tb2 = new JToggleButton(ii5, true);
		
		//tb2.setVisible(false); // 버튼 숨기기
		tb1.setRolloverSelectedIcon(ii3);
		tb2.setSelectedIcon(ii1);
		add(tb1); add(tb2);
		
		// setBackground() : 컴퍼넌트 or 컨테이너의 배경색
		btn2.setBackground(Color.pink);
		
		// 배경색 지정
		Color clr1 = new Color(150, 200, 50);
		rb1.setBackground(clr1);
		
		// 글자색 변경
		tb1.setForeground(Color.blue);
		
		//JLabel : 라벨 컴퍼넌트
		JLabel lbl1 = new JLabel(ii3);
		JLabel lbl2 = new JLabel("라벨", JLabel.CENTER);
		add(lbl1); add(lbl2);
		
		//라벨에 배경색 : 디폴트로 투명처리가 되어있어 배경색이 화면에 안보인다.
		lbl1.setBackground(Color.GRAY);
		lbl2.setBackground(Color.ORANGE);
		
		//투명처리
		lbl1.setOpaque(true);
		lbl2.setOpaque(true); // true : 투명해제, false : 투명
		
		// Tooltip = 마우스를 올렸을때 설명문?같은것이 화면에 출력되는것
		btn2.setToolTipText("버튼연습중...");
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JButtonTest();
	}
}
