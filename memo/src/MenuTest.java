import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	
	//글꼴
	JComboBox<String> fontName = new JComboBox<String>();
	
	String textBuffer;		
	//Font 관련기능
	int bold = 0, italic = 0;
	Font fnt = new Font("굴림체",0,14);
	
	//현재 작업중인 파일객체
	File nowFile;
	
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
		//메뉴바 만들기
		setJMenuBar(mb);
		
		//툴바
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		//글자크기 반복문
		for(int i=8; i<=70; i+=3) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		fontSize.setSelectedItem(14); // 초기 글자 크기
		tb.add(fontSize);
		add(BorderLayout.NORTH, tb);
		
		// 윈도우 운영체제의 글꼴 얻어오기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String [] fntList = ge.getAvailableFontFamilyNames();
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		ta.setFont(fnt);
		
		//단축키 설정
		setShortCut();
		
		setSize(1000,1000);
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
		
		// 툴바
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
	}
	//							JMenuItem, JButton, JComboBox를 매개변수에 받아낸다
	public void actionPerformed(ActionEvent ae) {
		//메뉴 인식
		String eventMenu = ae.getActionCommand();
		//버튼 인식, getSource:컴퍼넌스 구별없이 객체를 구해주는 메소드
		Object eventObj = ae.getSource();
		//이벤트가 발생한 객체가 어떤 클래스로 생성된 것인지 확인
		//객체A와 객체B가 같은지 boolean으로 리턴해주는 예약어 : instanceof
		if(eventObj instanceof JMenuItem) {
			if(eventMenu.equals("새문서")) {
				newFile();
			}else if(eventMenu.equals("열기")) {
				fileopen();
			}else if(eventMenu.equals("저장")){
				fileSave();
			}else if(eventMenu.equals("종료")) {
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
				startRuntime("C://Program Files/Google/Chrome/Application/chrome.exe https://www.nate.com");
				//크롬 브라우저 실행하기
				//startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe");
			}else if(eventMenu.equals("에디트플러스")) {
				//에디트 플러스 실행하기
				startRuntime("C://Program Files/EditPlus/editplus.exe");
			}else if(eventObj == boldBtn) {
				Font fnt = new Font("궁서체", Font.BOLD, 20);
				ta.setFont(fnt);
			}
		}else if(eventObj instanceof JButton) {
			if(eventObj == boldBtn) {
				if(bold == 0) {
					bold = 1;
				}else {
					bold = 0;
				}
				fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == italicBtn) {
				if(italic==0) italic=2;
				else italic=0;
				fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}else if(eventObj == openBtn) {
				fileopen();
			}else if(eventObj == newBtn) {
				newFile();
			}else if(eventObj == saveBtn) {
				fileSave();
			}
		}else if(eventObj instanceof JComboBox) {
			if(eventObj == fontSize || eventObj == fontName) {
				fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
		}
	}
	//새문서
	public void newFile() {
		nowFile = null; //작업문서객체 초기화
		ta.setText("");
		setTitle("메모장");
	}
	//파일저장
	public void fileSave() {
		if(nowFile==null) { //새문서를 작성 후 저장한다.
			JFileChooser fc = new JFileChooser();
			
			int state = fc.showSaveDialog(fc); // save = 0, cancle = 1
			if(state == 0) {//저장 버튼 선택시
				//선택한 드라이브명, 경로, 파일명
				File f = fc.getSelectedFile();
				//글내용
				String str = ta.getText();
				//중복된이름
				if(f.exists()) { //파일이 있는지 확인(return boolean)
					JOptionPane.showMessageDialog(this, "이미존재하는 파일명입니다.\n 저장하기가 취소되었습니다.");
				}else {
					try {
						//FileWriter객체
						FileWriter fw = new FileWriter(f);
						fw.write(str, 0, str.length());
						fw.flush();
						fw.close();
						
						nowFile = f;
						setTitle(f.getPath());
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}else { //이미 있는 문서를 열어서 수정 후 저장한다.
			String writeTxt = ta.getText();
			try {
				FileWriter fw = new FileWriter(nowFile);
				// 인덱스 0부터 writeTxt의 길이까지
				fw.write(writeTxt, 0, writeTxt.length());
				fw.flush();
				fw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 파일열기
	public void fileopen() {
		File f = new File("D://io");
		JFileChooser fc = new JFileChooser();//파일 탐색기\
		// 여러파일을 선택할 수 있도록 설정
		fc.setMultiSelectionEnabled(true); // true : 다중선택, false : 단일선택(디폴트값)
		
		// 필터 설정
		//						화면에 나오는 글자, 확장자
		FileFilter ff1 = new FileNameExtensionFilter("이미지", "jpg", "jpeg", "gif", "png", "bmp");
		fc.addChoosableFileFilter(ff1);
		
		FileFilter ff2 = new FileNameExtensionFilter("java","java","JAVA","Java");
		fc.addChoosableFileFilter(ff2);
		
		// 0:열기, 1:취소
		int state = fc.showOpenDialog(this);//파일탐색기 열림.
		if(state == 0) {
			try {
				ta.setText("");//원래 있는 컨텐츠 삭제
				//File selFile = fc.getSelectedFile(); 단일선택
				File selFile[] = fc.getSelectedFiles(); // 다중선택(배열사용) 
				
				for(File s : selFile) {
					//현재파일명을 JFrame에 제목으로 설정
					String path = s.getPath();
					setTitle(path);
					nowFile = s;
					FileReader fr = new FileReader(s);
					BufferedReader br = new BufferedReader(fr);
					
					while(true) {
						// bufferedreader 한줄 읽기(데이터가 없을때까지 반복)
						String inData = br.readLine();
						if(inData==null) {
							break;
						}
						//한줄 추가 후 엔터
						ta.append(inData+"\n");
					}//while
					//ta.append("----------------------------------------------------\n");
				}//for
			}catch(Exception e) {
				System.out.println("파일열기 에러 발생....");
				e.printStackTrace();
			}
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
