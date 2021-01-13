import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainClass extends JFrame implements ActionListener{
	JPanel paneTop = new JPanel();
	JPanel paneMiddle = new JPanel(new GridLayout(1,3,0,0));
	JPanel paneBottom = new JPanel(new GridLayout(4,4,0,0));
	
	JButton btnBsb = new JButton("BackSpaceBar");
	JButton btnClear = new JButton("Clear");
	JButton btnEnd = new JButton("End");
	
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btnP = new JButton("+");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btnBBa = new JButton("-");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btnX = new JButton("*");
	JButton btn0 = new JButton("0");
	JButton btnDot = new JButton(".");
	JButton btnCol = new JButton("=");
	JButton btnSal = new JButton("/");
	
	JTextArea textAr = new JTextArea();
	JTextField textFd = new JTextField(30);
	List<String> al = new ArrayList<String>();
	List<Integer> resultAl = new ArrayList<Integer>();
	public MainClass() {
		super("계산기");
		
		add(BorderLayout.NORTH, paneTop);
		paneTop.add(textAr);
		
		add(BorderLayout.CENTER, paneMiddle);
		paneMiddle.add(btnBsb); paneMiddle.add(btnClear); paneMiddle.add(btnEnd);
		
		
		add(BorderLayout.SOUTH, paneBottom);
		paneBottom.add(btn7); paneBottom.add(btn8); paneBottom.add(btn9); paneBottom.add(btnP);
		paneBottom.add(btn4); paneBottom.add(btn5); paneBottom.add(btn6); paneBottom.add(btnBBa);
		paneBottom.add(btn1); paneBottom.add(btn2); paneBottom.add(btn3); paneBottom.add(btnX);
		paneBottom.add(btn0); paneBottom.add(btnDot); paneBottom.add(btnCol); paneBottom.add(btnSal);
		
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btnP.addActionListener(this);
		btnCol.addActionListener(this);
		btnClear.addActionListener(this);
		
		
		setSize(400,200);
		setVisible(true);
		setLocation(300,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String emp = "";
		int result = 0;
		//7번 버튼, 8번 버튼, 더하기 처리까지만 구현했습니다....
		if(obj == btn7) {
			textAr.append(btn7.getText());
			al.add(btn7.getText());
		}else if(obj == btn8) {
			textAr.append(btn8.getText());
			al.add(btn8.getText());
		}else if(obj == btnP) {
			textAr.append(btnP.getText());
			for(int i=0; i<al.size(); i++) {
				emp = emp + al.get(i);
				System.out.print(al.get(i));
			}
			al.clear();
			resultAl.add(Integer.parseInt(emp));
		}else if(obj == btnCol) {
			textAr.append(btnCol.getText());
			for(int i=0; i<al.size(); i++) {
				emp = emp + al.get(i);
			}
			resultAl.add(Integer.parseInt(emp));
			
			for(int i=0; i<resultAl.size(); i++) {
				result += resultAl.get(i);
			}
			textAr.append(result+"");
		}else if(obj == btnClear) {
			textAr.setText("");
		}
		textFd.setText("");
		//textFd.getText();
	}
	
	
	public static void main(String[] args) {
		new MainClass();
	}

}
