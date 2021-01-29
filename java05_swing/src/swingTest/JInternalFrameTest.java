package swingTest;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/* JInternalFrame : Panel 안에 존재하는 창, 여러개 생성가능 > Panel 밖으로 뺄 수 없게 할 수 있다(JDesktopPane)
 * 
 * 
 * 
 * 
 */

public class JInternalFrameTest extends JFrame implements ActionListener, ChangeListener, ListSelectionListener{
	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2, if3, if4;
	JTextArea ta = new JTextArea();
	
	JToolBar tb = new JToolBar();
		JButton saveBtn = new JButton("저장");
		JButton colorBtn = new JButton("색상표-글자색");
		JButton calBtn = new JButton("계산기");
		
	JSlider redSlider = new JSlider(JSlider.HORIZONTAL,0,255,150);
	
	JList<String> list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		String flower[] = {"멘드라미","튤립","코스모스","장미","해바라기","히야신스","안개꽃","접시꽃"};
		JScrollPane sp = new JScrollPane(list);
	public JInternalFrameTest() {
		add("North", tb);
		tb.add(saveBtn); tb.add(colorBtn); tb.add(calBtn);
		
		add("South", redSlider);
		redSlider.setMajorTickSpacing(50);//주눈금
		redSlider.setMinorTickSpacing(5);//보조눈금
		redSlider.setPaintTicks(true);//눈금 보여주기
		redSlider.setPaintLabels(true);//라벨 표시
		redSlider.setSnapToTicks(true);//가까운 눈금선으로 스티이 이동한다.
		add(dp);
		
		for(String flowerName : flower) {
			model.addElement(flowerName);
		}
		list.setModel(model);
		add("East",list);
		
		//JInternalFrame 만들기
		if1 = new JInternalFrame(); // default setting: BorderLayout()
		if1.add(ta);
		if1.setSize(300,300);
		if1.setVisible(true);
		dp.add(if1);
		
		//Stirng title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable
		//타이틀, 리사이즈, 닫기, 최대화, 최소화
		if2 = new JInternalFrame("달력", true, true, true, false);
		CalendarSwing cs = new CalendarSwing();
		if2.add(cs);
		// x , y, w, h
		if2.setBounds(100,100,400,300);
		if2.setVisible(true);
		dp.add(if2);
			
		if3 = new JInternalFrame("시계");
		DigitalClock dc = new DigitalClock();
		Thread t = new Thread(dc);
		t.start();
		if3.add(dc);
		if3.setBounds(1,500,500,200);
		if3.setVisible(true);
		dp.add(if3);
		
		if4 = new JInternalFrame("팩맨", false, true, false, false);
		PackMan packMan = new PackMan();
		if4.add(packMan);
		if4.setBounds(150,1,500,500);
		if4.setVisible(true);
		dp.add(if4);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		try {
			if2.setSelected(true);
			if4.setSelected(true);
			Thread t2 = new Thread(packMan);
			t2.start();
			packMan.getPackManSize();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//이벤트 등록
		saveBtn.addActionListener(this);
		colorBtn.addActionListener(this);
		redSlider.addChangeListener(this);
		list.addListSelectionListener(this);
		calBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==saveBtn) {
			//활성화 되어있는 JInternalFrame객체 얻어오기
			JInternalFrame eventIf = dp.getSelectedFrame();
			if(eventIf == if1) {
				JTextArea eventTa= (JTextArea)eventIf.getFocusOwner(); //커서가있는 컴퍼넌트를 구해준다.
				String taStr = eventTa.getText();
				try {
					FileWriter fw = new FileWriter(new File("D://io//internal.txt"));
					fw.write(taStr);
					fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(obj == colorBtn) {
			JColorChooser cc = new JColorChooser(Color.blue);
			//			  부모컨테이너, 창제목, 기본색상 
			Color color = cc.showDialog(this, "색상표", Color.green);
			ta.setForeground(color);
		}else if(obj == calBtn) {
			//							부모컴퍼넌스, 제목, 창이띄워저있을때 다른창 클릭 여부(true:클릭불가, false:클릭가능)
			JDialog dialog = new JDialog(this, "계산기", true);
			Calculator cal = new Calculator();
			dialog.add(cal);
			dialog.setSize(400, 500);
			dialog.setVisible(true);
		}
	}
	public void stateChanged(ChangeEvent ce) {
		if(ce.getSource()==redSlider) {
			ta.setBackground(new Color(redSlider.getValue(),100,100));
		}
	}
	public void valueChanged(ListSelectionEvent lse) {
		List<String> selectList = list.getSelectedValuesList();
		String txt="";
		for(int i=0; i<selectList.size(); i++) {
			//ta.append(selectList.get(i)+'\n');
			txt += selectList.get(i) + "\n";
		}
		ta.setText(txt);
	}
	public static void main(String[] args) {
		new JInternalFrameTest();

	}

}