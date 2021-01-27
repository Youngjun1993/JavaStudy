package swingTest;
//이영준
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// JFrame 클래스 상속 / JCombobox 이벤트, JButton이벤트 인터페이스 상속
public class CalendarSwing extends JPanel implements ItemListener, ActionListener{
	// Font타입 fnt 래퍼런스 변수에 객체 생성
	Font fnt = new Font("굴림", Font.BOLD, 20);
	// Jpanel타입 selectPane 래퍼런스변수에 객체 생성(디폴트:FlowLayout)
	JPanel selectPane = new JPanel();
		//selectPane에 들어갈 JButton 객체 생성
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		// selectPane에 들어갈 제네릭이 Integer 타입인 JComboBox 객체 생성
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		// 각 JcomboBox옆에 들어갈 라벨 객체 생성
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
		
		//가운데 패널 객체 생성(BorderLayout)
		JPanel centerPane = new JPanel(new BorderLayout());
			//요일을 담을 패널 객체 생성(GridLayout:1행 7열)
			JPanel titlePane = new JPanel(new GridLayout(1,7));
				//요일 배열
				String[] title= {"일","월","화","수","목","금","토"};
			//날짜를 담을 패널 객체 생성(GridLayout:유동, 7열)
			JPanel dayPane = new JPanel(new GridLayout(0,7));
		
		//달력관련 데이터
		Calendar date;
		int year;
		int month;
	//생성자 메소드
	public CalendarSwing() {
		setLayout(new BorderLayout());
//		super("달력");	//프레임 타이틀 입력
		date = Calendar.getInstance();		//현재의 날짜 시간 객체 생성
		year = date.get(Calendar.YEAR);		//현재 날짜의 년도를 year변수에 대입
		month = date.get(Calendar.MONTH)+1;	//현재 날짜의 월을 month에 대입
		//상단
		selectPane.setBackground(new Color(150,200,200));	//상단 selectPane에 배경색 변경
		//selectPane에 있는 객체들의 폰트 설정
		selectPane.add(prevBtn); prevBtn.setFont(fnt);
		selectPane.add(yearCombo); yearCombo.setFont(fnt);
		selectPane.add(yearLbl); yearLbl.setFont(fnt);
		selectPane.add(monthCombo); monthCombo.setFont(fnt);
		selectPane.add(monthLbl); monthLbl.setFont(fnt);
		selectPane.add(nextBtn); nextBtn.setFont(fnt);
		//현재 프레임(JFrame) 북쪽에 selectPane 추가
		add(BorderLayout.NORTH, selectPane);
		//현재 년, 월 설정
		setYear();
		setMonth();
		
		//title호출
		setCalendarTitle();
		// centerPane 패널 북쪽에 titlePane 추가
		centerPane.add(BorderLayout.NORTH, titlePane);
		//현재 프레임(JFrame)에 centerPane 추가
		add(centerPane);
		
		//날짜 만들기
		//centerPane 패널 북쪽에 dayPane 추가
		centerPane.add(dayPane); 
		//setDay() 메소드 호출
		setDay();
//		//프레임 사이즈 설정
//		setSize(400,300);
//		//프레임 보여지기 설정
//		setVisible(true);
//		//프레임에 X버튼 핸들링
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//ComboBox 이벤트 등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		//JButton 이벤트 등록
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	
	}
	//AtionListener 인터페이스에 있는 메소드 오버라이딩
	@Override
	public void actionPerformed(ActionEvent ae) {
		//Object타입 obj 래퍼런스 변수에 ActionEvent타입 ae매개변수에 들어가는 객체대입
		Object obj = ae.getSource();
		if(obj == prevBtn) {		//obj에 객체가 prevBtn(JButton)객체와 같다면
			//prevMonth 메소드 호출
			prevMonth();
			//setDayReset 메소드 호출
			setDayReset();
		}else if(obj == nextBtn) {	//obj에 객체가 nextBtn(JButton)객체와 같다면
			//nextMonth 메소드 호출
			nextMonth();
			//setDayReset 메소드 호출
			setDayReset();
		}
	}
	public void setDayReset() {
		//년월 이벤트등록 해제
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		//ComboBox에 있는 데이터 셋팅값 선택
		yearCombo.setSelectedItem(year); //itemevent발생
		monthCombo.setSelectedItem(month);
		//dayPane패널 숨기기
		dayPane.setVisible(false);
		//dayPane패널 전체삭제
		dayPane.removeAll();
		//setDay()메소드 호출
		setDay();
		//dayPane패널 나타나기
		dayPane.setVisible(true);
		
		//년월 이벤트 다시등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	}
	public void nextMonth() {
		//month가 12와 같다면
		if(month==12) {
			year++;		// year는 증가
			month=1;	// month는 1로 초기화
		//month가 12와 같지 않다면
		}else {	
			month++; 	//month 증가
		}
	}
	public void prevMonth() {
		// month가 1과 같다면
		if(month==1) {
			year--;		// year 감소
			month=12;	// month는 12로 초기화
		}else {
			month--;	// moth 감소
		}
	}
	//ItemListener 인터페이스에 있는 메소드 오버라이딩
	@Override
	public void itemStateChanged(ItemEvent ie) {
		//ComboBox에 선택된 데이터를 int타입으로 형변환 후 각 변수에 대입
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		//dayPane패널 숨기기
		dayPane.setVisible(false);
		dayPane.removeAll();//원래있는 날짜 지우기
		setDay();//날짜 처리 함수 호출
		dayPane.setVisible(true);//dayPane 보이기
	}
	//날짜 셋팅
	public void setDay() {
		//요일
		date.set(year, month-1, 1); //Calendar 추상클래스 초기값 셋팅
		int week = date.get(Calendar.DAY_OF_WEEK); //한주에 대한 요일수 대입
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		//공백 처리
		for(int s=1; s<week; s++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		//날짜 추가
		for(int day=1; day<=lastDay; day++) {
			//JLabel타입 lbl 래퍼런스 변수에 객체생성(day를 String형으로 형변환, JLabel을 가운데 정렬)
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER);
			//lbl변수 폰트 셋팅
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일
			date.set(Calendar.DATE, day); // 19 -> 1
			int w = date.get(Calendar.DAY_OF_WEEK);
			//조건에 맞을때 색상 변경
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
		
	}
	//년도 셋팅
	public void setYear() {
		//i=현재년도-50, i가 현재년도+20보다 작다면, i증가
		for(int i=year-50; i<year+20; i++) {
			yearCombo.addItem(i); //yearCombo에 i 추가
		}
		yearCombo.setSelectedItem(year); // yearCombo에 셋팅되어있는 값 중 year값으로 선택
	}
	//월셋팅
	public void setMonth() {
		//월은 12월이 최대이므로 아래와 같은 조건
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i); //monthCombo에 i 추가
		}
		monthCombo.setSelectedItem(month); // monthCombo에 셋팅되어있는 값 중 month값으로 선택
	}
	//월화수목 타이틀 설정
	public void setCalendarTitle() {
		//일,월,화,수,목,금,토 읽어오기
		for(int i=0; i<title.length; i++) {
			//읽어낸 요일명을 lbl에 대입, 가운데 정렬
			JLabel lbl = new JLabel(title[i], JLabel.CENTER);
			//폰트 셋팅
			lbl.setFont(fnt);
			//조건에 맞을때 색상 변경
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
//	public static void main(String[] args) {
//		new CalendarSwing();
//	}

}
