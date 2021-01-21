import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserManagement extends JFrame{
	JPanel paneInput = new JPanel(new GridLayout(7,0));
		JPanel paneNum = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblNum = new JLabel("번호"); JTextField tfNum = new JTextField(4);
		JPanel paneName = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblName = new JLabel("이름"); JTextField tfName = new JTextField(10);
		JPanel paneTel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblTel = new JLabel("전화번호"); JTextField tfTel = new JTextField(20);
		JPanel paneEmail = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblEmail = new JLabel("이메일"); JTextField tfEmail = new JTextField(20);
		JPanel paneAddr = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblAddr = new JLabel("주소"); JTextField tfAddr = new JTextField(40);
		JPanel paneDate = new JPanel(new FlowLayout(FlowLayout.LEFT,0,5));
			JLabel lblDate = new JLabel("등록일"); JTextField tfDate = new JTextField(40);
		//중앙 버튼 패널
		JPanel paneBtn = new JPanel(new GridLayout(0,7));
			//JButton 7개
		
	JPanel paneTable = new JPanel(new BorderLayout());
		//Table
		JTable table;
		DefaultTableModel model;
		JScrollPane sp;
		
	JPanel paneSearch = new JPanel();
		//textfield / jbutton
		JTextField tfSearch = new JTextField(20);
		JButton btnSearch = new JButton("Search");
		
	Font fnt = new Font("궁서체",Font.BOLD,15);
	public UserManagement() {
		//상단 라벨 간격조정
		lblNum.setPreferredSize(new Dimension(60, 20));
		lblName.setPreferredSize(new Dimension(60, 20));
		lblTel.setPreferredSize(new Dimension(60, 20));
		lblEmail.setPreferredSize(new Dimension(60, 20));
		lblAddr.setPreferredSize(new Dimension(60, 20));
		lblDate.setPreferredSize(new Dimension(60, 20));
		
		//각 패널에 new FlowLayout(FlowLayout.LEFT,10,5)으로 한줄씩 출력하기
		paneNum.add(lblNum); paneNum.add(tfNum);
		paneName.add(lblName); paneName.add(tfName);
		paneTel.add(lblTel); paneTel.add(tfTel);
		paneEmail.add(lblEmail); paneEmail.add(tfEmail);
		paneAddr.add(lblAddr); paneAddr.add(tfAddr);
		paneDate.add(lblDate); paneDate.add(tfDate);
		
		//메인패널인 paneInput에 위 패널들 추가
		paneInput.add(paneNum);paneInput.add(paneName);paneInput.add(paneTel);
		paneInput.add(paneEmail);paneInput.add(paneAddr);paneInput.add(paneDate);
		
		//paneBtn에 들어갈 버튼
		String btnStr[] = {"추가","수정","삭제","지우기","종료","엑셀로저장","엑셀로불러오기"};
		for(int i=0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			paneBtn.add(btn);
		}
		paneInput.add(paneBtn);
		
		//paneInput패널을 프레임에 North로 추가
		add(BorderLayout.NORTH, paneInput);
		
		//paneTable에 들어갈 Jtable셋팅
		Object title[]= {"번호","이름","전화번호","이메일","주소","등록일"};
		Object data[][] = new Object[0][0];
		
		table = new JTable(data, title);
		sp = new JScrollPane(table);
		paneTable.add(sp);
		add(BorderLayout.CENTER, paneTable);
		
		//하단 Search 구현
		paneSearch.add(tfSearch); paneSearch.add(btnSearch);
		add(BorderLayout.SOUTH, paneSearch);
		
		//JFrame 초기 셋팅
		//pack();
		setSize(900,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void menuBtn() {
		
	}

	public static void main(String[] args) {
		new UserManagement();
	}

}
