import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//								패널을 상속받아 이 자체가 패널이 된다.
public class Calculator extends JPanel implements ActionListener{
	Font fnt = new Font("Arial", Font.BOLD, 20);
	
	//JFrame - North
	JTextField resultTf = new JTextField("0.0");
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout()); //디폴트 레이아웃 : Flow  
	JPanel northPane = new JPanel(new GridLayout(1,3));
	JPanel btnPane = new JPanel(new GridLayout(4,4));
	
	String btnLbl[] = {"BackSpace","Clear","End",
						"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0",".","=","/"};
	//연산자보관할 변수
	String operator = "";
	//피연산자 보관
	double result = 0.0;
	
	public Calculator() {
		setLayout(new BorderLayout());
		//JFrame - North
		add("North", resultTf);
		resultTf.setFont(fnt);
		//내용을 오른쪽 정렬
		resultTf.setHorizontalAlignment(JTextField.RIGHT);
		
		//JFrame - Center
		centerPane.add("North", northPane);
		centerPane.add(BorderLayout.CENTER, btnPane);
		add("Center", centerPane);
		
		//버튼 생성
		for(int i=0; i<btnLbl.length; i++) {
			JButton btn = new JButton(btnLbl[i]);
			btn.setFont(fnt); //글꼴, 유형, 크기 세팅
			if(i<=2) {
				northPane.add(btn);
			}else {
				btnPane.add(btn);
				btn.setBackground(Color.LIGHT_GRAY);
			}
			//이벤트 등록
			btn.addActionListener(this);
		}
		
	}
	//오버라이딩
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		switch(eventBtn) {
			case "End": System.exit(0); break;
			case "0": case "1": case "2": case "3": case "4": case "5":
			case "6": case "7": case "8": case "9":
				setNumber(eventBtn);
				break;
			case ".":
				setPoint();
				break;
			case "BackSpace":
				setBackSpace();
				break;
			case "+": case "-": case "*": case "/":
				setOperator(eventBtn);
				break;
			case "=":
				setResult();
				break;
			case "Clear":
				setClear();
				break;
		}
	}
	//데이터 초기화
	public void setClear() {
		result = 0.0;
		operator = "";
		resultTf.setText("0.0");
	}
	//연산하기
	public void setResult() {
		double secondNum = Double.parseDouble(resultTf.getText());
		switch(operator) {
			case "+": result = result + secondNum; break;
			case "-": result -= secondNum; break;
			case "*": result *= secondNum; break;
			case "/": result /= secondNum; break;
		}
		resultTf.setText(String.valueOf(result)); // double형을 String으로 변환
		operator = "";
	}
	//연산자 버튼 선택시(+, -, *, /)
	public void setOperator(String operator) {
		//연산자 보관
		this.operator = operator;
		result = Double.parseDouble(resultTf.getText()); //숫자보관
		resultTf.setText("");
	}
	//BackSpace처리
	public void setBackSpace() {
		String lblStr = resultTf.getText(); //123468
		String cutStr = lblStr.substring(0, lblStr.length()-1);  //12346을 구한다.
		resultTf.setText(cutStr);
	}
	//소수점 처리
	public void setPoint() {
		String lblstr = resultTf.getText();
		int idx = lblstr.indexOf("."); // .위치 구하기
		if(idx == -1) {
			resultTf.setText(lblstr+".");
		}
	}
	//숫자버튼을 선택하면
	public void setNumber(String num) {
		//JTextField 원래값 얻어오기
		String lblstr = resultTf.getText(); // 0.0
		if(lblstr.equals("0.0")) {
			resultTf.setText(num); // 클릭한 숫자버튼을 셋팅
		}else {
			resultTf.setText(lblstr+num);
		}
	}
}
