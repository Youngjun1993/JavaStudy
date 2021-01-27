package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSPlitPaneTest2 extends JFrame{
	
	Calculator cal = new Calculator();
	CalendarSwing calendar = new CalendarSwing();
	PackMan packMan = new PackMan();
	
	JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cal, calendar);
	JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, packMan, sp2);
	
	public JSPlitPaneTest2() {
		add(sp1);
		
		sp2.setDividerLocation(600);
		sp1.setDividerLocation(300);
		
		setSize(1200,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Thread t1 = new Thread(packMan);
		t1.start();
	}

	public static void main(String[] args) {
		new JSPlitPaneTest2();
	}

}
