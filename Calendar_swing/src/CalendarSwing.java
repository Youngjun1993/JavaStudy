import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwing extends JFrame implements ItemListener{
	Font fnt = new Font("굴림", Font.BOLD, 20);
	
	JPanel selectPane = new JPanel();
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
		
		//가운데
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel titlePane = new JPanel(new GridLayout(1,7));
				String[] title= {"일","월","화","수","목","금","토"};
			JPanel dayPane = new JPanel(new GridLayout(0,7));
		
		//달력관련 데이터
		Calendar date;
		int year;
		int month;
	public CalendarSwing() {
		super("달력");
		date = Calendar.getInstance(); //현재의 날짜 시간 객체 생성
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH)+1;
		//상단
		selectPane.setBackground(new Color(150,200,200));
		selectPane.add(prevBtn); prevBtn.setFont(fnt);
		selectPane.add(yearCombo); yearCombo.setFont(fnt);
		selectPane.add(yearLbl); yearLbl.setFont(fnt);
		selectPane.add(monthCombo); monthCombo.setFont(fnt);
		selectPane.add(monthLbl); monthLbl.setFont(fnt);
		selectPane.add(nextBtn); nextBtn.setFont(fnt);
		
		add(BorderLayout.NORTH, selectPane);
		//현재 년, 월 설정
		setYear();
		setMonth();
		
		//title호출
		setCalendarTitle();
		centerPane.add(BorderLayout.NORTH, titlePane);
		add(centerPane);
		
		//날짜 만들기
		centerPane.add(dayPane);
		setDay();
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false);
		dayPane.removeAll();//원래있는 날짜 지우기
		setDay();//날짜 처리 함수 호출
		dayPane.setVisible(true);
	}
	//날짜 셋팅
	public void setDay() {
		//요일
		date.set(year, month-1, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		//공백
		for(int s=1; s<week; s++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		//날짜 추가
		for(int day=1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER);
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일
			date.set(Calendar.DATE, day); // 19 -> 1
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
		
	}
	//년도 셋팅
	public void setYear() {
		for(int i=year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		yearCombo.setSelectedItem(year);
	}
	//월셋팅
	public void setMonth() {
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month);
	}
	//월화수목 타이틀 설정
	public void setCalendarTitle() {
		for(int i=0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i], JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
	public static void main(String[] args) {
		new CalendarSwing();
	}

}
