package swingTest;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JPanel implements Runnable{
	JLabel lbl = new JLabel("00:00:00",JLabel.CENTER);
	Font fnt = new Font("굴림체",Font.BOLD, 100);
	public DigitalClock() {
		setLayout(new BorderLayout());
//		setTitle("Clock");
		lbl.setFont(fnt);
		add(lbl);
		
		//setSize(w, h), setBounds(x, y, w, h), pack():컨텐츠 내용만큼 크기 설정
//		setBounds(x,y,w,h);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void run() {
		while(true) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String txt = format.format(now.getTime());
			lbl.setText(txt);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}
