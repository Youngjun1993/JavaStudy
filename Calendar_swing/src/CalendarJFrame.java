import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalendarJFrame extends JFrame{
	JTextArea taArea = new JTextArea();
	JTextArea taDay = new JTextArea();
	JTextArea taYear = new JTextArea();
	JTextArea taMonth = new JTextArea();
	
	JComboBox<Integer> cb1, cb2;
	
	Vector<Integer> vYear = new Vector<Integer>();
	Vector<Integer> vMonth = new Vector<Integer>();
	
	JButton btnLeft = new JButton("◀");
	JButton btnRight = new JButton("▶");
	
	Calendar calendar = Calendar.getInstance();
	
	JPanel pane = new JPanel();
	Font fnt = new Font("맑은 고딕", Font.BOLD, 20);
	
	public CalendarJFrame(){
		super("카렌다");
		//달력값 셋팅
		int year=0,month=0;
		taArea.setFont(fnt);
		/*
		for(int i=1990; i<2030; i++) {
			calendar.set(Calendar.YEAR, i);
			vYear.add(calendar.get(Calendar.YEAR));
		}
		*/
		calendar.set(Calendar.YEAR, 2021);
		vYear.add(calendar.get(Calendar.YEAR));
		year = 2021;
		
		pane.setBackground(Color.CYAN);
		
		cb1 = new JComboBox<Integer>(vYear);
		pane.add(btnLeft);
		pane.add(cb1);
		taYear.setText("년");
		pane.add(taYear);
		
		for(int i=0; i<12; i++) {
			calendar.set(Calendar.MONTH, i);
			vMonth.add(calendar.get(Calendar.MONTH)+1);
			month = i+1;
		}
		
		cb2 = new JComboBox<Integer>(vMonth);
		pane.add(cb2);
		taMonth.setText("월");
		pane.add(taMonth);
		pane.add(btnRight);
		add("North",pane);
		
		//TextArea에 날짜 출력
		calendar.set(year, month, 1);
		
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		ArrayList<String> arrayList = new ArrayList<String>();
		//taDay.setText("\t일\t월\t화\t수\t목\t금\t토\t\n");
		//add(taDay);
		//공백 입력
		for(int i=1; i<week; i++) {
			arrayList.add("\t");
		}
		
		//날짜 입력
		for(int i=1; i<=lastDay; i++) {
			arrayList.add(i + "\t");
			if((i+week-1)%7==0) {
				arrayList.add("\n");
			}
		}
		
		//화면 출력
		String output="일\t월\t화\t수\t목\t금\t토\n";
		for(int i=0; i<arrayList.size(); i++) {
			if((i+week-1)%7==0) {
				taArea.setFont(fnt);
			}
			output += arrayList.get(i);
		}
		taArea.setText(output);
		add(taArea);
		
		
		setSize(1000,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CalendarJFrame();
	}

}
