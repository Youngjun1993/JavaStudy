import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CalendarJFrame extends JFrame implements ActionListener{
	JTextArea taDay = new JTextArea();
	JTextArea taYear = new JTextArea();
	JTextArea taMonth = new JTextArea();
	
	JComboBox<Integer> cb1, cb2;
	
	Vector<Integer> vYear = new Vector<Integer>();
	Vector<Integer> vMonth = new Vector<Integer>();
	
	Calendar calendar = Calendar.getInstance();
	
	JPanel pane = new JPanel(new BorderLayout());
	JPanel topPane = new JPanel();
	JPanel dayPane = new JPanel(new GridLayout(0,7));
	JPanel calenPane = new JPanel(new GridLayout(0,7));
	
	JButton btnLeft = new JButton("◀");
	JButton btnRight = new JButton("▶");
	
	ArrayList<String> arrayList = new ArrayList<String>();
	
	Font fnt = new Font("맑은 고딕", Font.BOLD, 20);
	int year=0,month=0;
	int monthOut=1;
	
	public CalendarJFrame(){
		super("카렌다");
		setLayout(new BorderLayout());
		//달력값 셋팅
		/*
		for(int i=1990; i<2030; i++) {
			calendar.set(Calendar.YEAR, i);
			vYear.add(calendar.get(Calendar.YEAR));
		}
		*/
		
		//상단 툴바 설정
		calendar.set(Calendar.YEAR, 2021);
		vYear.add(calendar.get(Calendar.YEAR));
		year = 2021;
		
		topPane.setBackground(Color.CYAN);
		
		cb1 = new JComboBox<Integer>(vYear); cb1.setFont(fnt);
		topPane.add(btnLeft);
		topPane.add(cb1);
		taYear.setText("년"); taYear.setFont(fnt); taYear.setBackground(Color.cyan);
		topPane.add(taYear);
		
		for(int i=0; i<12; i++) {
			//calendar.set(Calendar.MONTH, i);
			//vMonth.add(calendar.get(Calendar.MONTH)+1);
			month = i+1;
			vMonth.add(month);
		}
		
		cb2 = new JComboBox<Integer>(vMonth); cb2.setFont(fnt);
		topPane.add(cb2);
		
		taMonth.setText("월"); taMonth.setFont(fnt); taMonth.setBackground(Color.cyan);
		topPane.add(taMonth);
		topPane.add(btnRight);
		add("North",topPane);
		
		//달력 호출
		calendarOut();
		
		setSize(450,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//버튼 이벤트 등록
		btnRight.addActionListener(this);
		btnLeft.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == btnLeft) {
			monthOut=monthOut-1;
			arrayList.clear();
			dayPane.removeAll();
			calenPane.removeAll();
			calendarOut();
			//콤보박스 월감소
			cb2.setSelectedItem(monthOut);
		}else if(obj == btnRight) {
			monthOut=monthOut+1;
			arrayList.clear();
			dayPane.removeAll();
			calenPane.removeAll();
			calendarOut();
			//콤보박스 월증가
			cb2.setSelectedItem(monthOut);
		}
	}
	//달력 메소드
	public void calendarOut() {
		//달력 초기값 선언
		calendar.set(year, monthOut-1, 1);
				
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String day[] = {"일","월","화","수","목","금","토"};
		//요일라벨 입력 및 출력
		for(int i=0; i<day.length; i++) {
			JLabel dayLbl = new JLabel(day[i]);
			dayLbl.setFont(fnt);
			dayLbl.setHorizontalAlignment(SwingConstants.CENTER);
			if(day[i] == day[0]) {
				dayLbl.setForeground(Color.red);
			}else if(day[i] == day[6]) {
				dayLbl.setForeground(Color.blue);
			}
			dayPane.add(dayLbl);
		}
		
		//공백 대입
		for(int i=1; i<week; i++) {
			arrayList.add(" ");
		}
		
		//날짜 대입
		for(int i=1; i<=lastDay; i++) {
			arrayList.add(i+"");
		}
		
		//날짜라벨 입력 및 출력
		for(int i=0; i<arrayList.size(); i++) {
			JLabel lbl = new JLabel(arrayList.get(i));
			lbl.setFont(fnt);
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			if(i%7==0) {
				lbl.setForeground(Color.red);
			}else if(i%7==6) {
				lbl.setForeground(Color.blue);
			}
			calenPane.add(lbl);
		}
		pane.add("North",dayPane);
		pane.add(BorderLayout.CENTER, calenPane);
		add("Center", pane);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalendarJFrame();
	}

}
