import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MenuTest extends JFrame implements ActionListener{
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromeMunuItem = new JMenuItem("크롬");
			JMenu editor = new JMenu("편집기");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
			
	// 툴바 만들기
	JToolBar tb = new JToolBar();
	//새문서
	ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
	//저장
	ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
	//열기
	ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
	//진하게
	ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); JButton boldBtn = new JButton(boldIcon);
	//이탤릭
	ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
	
	//글자크기
	JComboBox<Integer> fontSize = new JComboBox<Integer>();
	//배열보다 모델을 사용해 데이터 담는다.
	DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();
	
	
	
	String textBuffer;			
	public MenuTest() {
		super("메모장");
		add(sp);
		//파일 메뉴
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();//경계선
		fileMenu.add(endMenuItem);
		mb.add(fileMenu);
		//편집 메뉴
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		mb.add(editMenu);
		//실행 메뉴
		runMenu.add(chromeMunuItem);
		runMenu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);
		mb.add(runMenu);
		
		setJMenuBar(mb);
		
		//툴바
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		add(BorderLayout.NORTH, tb);
		
		//글자크기 반복문
		for(int i=8; i<=70; i+=3) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		tb.add(fontSize);
		
		//단축키 설정
		setShortCut();
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//메뉴를 이벤트 등록
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		chromeMunuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		//메뉴 인식
		String eventMenu = ae.getActionCommand();
		//버튼 인식
		Object eventObj = ae.getSource();
		
		if(eventMenu.equals("종료")) {
			System.exit(0);
		}else if(eventMenu.equals("오려두기")){
			setCut();
		}else if(eventMenu.equals("붙여넣기")) {
			setPaste();
		}else if(eventMenu.equals("복사하기")) {
			setCopy();
		}else if(eventMenu.equals("메모장")) {
			startRuntime("notepad.exe");
		}else if(eventMenu.equals("크롬")) {
			//크롬 브라우저로 해당 도메인주소로 접속하기
			startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.nate.com");
			//크롬 브라우저 실행하기
			//startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe");
		}else if(eventMenu.equals("에디트플러스")) {
			//에디트 플러스 실행하기
			startRuntime("C://Program Files/EditPlus/editplus.exe");
		}else if(eventObj == boldBtn) {
			Font fnt = new Font("궁서체", Font.BOLD, 20);
			ta.setFont(fnt);
		}
	}
	//외부 실행형 파일 구현
	public void startRuntime(String process){
		Runtime run = Runtime.getRuntime();
		try {
			run.exec(process);
		}catch(IOException ie) {
			ie.getStackTrace();
		}
	}
	//복사하기
	public void setCopy() {
		textBuffer = ta.getSelectedText();
	}
	//오려둔값 커서있는 자리에 붙여넣기
	public void setPaste() {
		if(textBuffer!=null && !textBuffer.equals("")) {
			ta.replaceSelection(textBuffer);
		}
	}
	//오려두기
	public void setCut() {
		//선택된 텍스트 변수에 저장
		textBuffer = ta.getSelectedText();
		//선택된 텍스트 공백처리
		ta.replaceSelection("");
	}
	//단축키 설정
	public void setShortCut() {
		//종료 : ctrl+e
		//E : 단축키를 무엇으로 할것인지 설정
		endMenuItem.setMnemonic(KeyEvent.VK_E);
		//ctrl 단축키의 Mask설정								단축키		MASK
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	
		//새문서 : ctrl + n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		//열기 : alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
		//저장 : ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
	}
	public static void main(String[] args) {
		new MenuTest();
	}										
					
}
