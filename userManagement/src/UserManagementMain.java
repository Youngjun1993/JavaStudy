import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class UserManagementMain extends JFrame implements ActionListener{
   //JFrame - North - 회원폼
   JPanel mainNorthPane = new JPanel(new BorderLayout());
      JPanel formLabelPane = new JPanel(new GridLayout(6,1));
         String lbl[] = {"번호", "이름", "전화번호", "이메일", "주소", "등록일"};
      JPanel formCenterPane =  new JPanel(new GridLayout(6,1));
         JTextField tf[] = {new JTextField(4), new JTextField(10), new JTextField(20), new JTextField(30), new JTextField(50), new JTextField(15)};
   
   //JFrame - Center - 버튼, JTable, 검색
   JPanel mainCenterPane = new JPanel(new BorderLayout());
      //버튼들
      JPanel buttonPane = new JPanel(new GridLayout(1,0));
         String btnLbl[] = {"전체목록","추가","수정","삭제","지우기","종료","엑셀로쓰기","엑셀에서가져오기"};
      //JTable
      JTable table;
         JScrollPane sp;
         DefaultTableModel model;
         
   //JFrame - South -검색
   JPanel searchPane = new JPanel();
   JTextField searchTf = new JTextField(20);
   JButton searchBtn = new JButton("Search");
   
   public UserManagementMain() {
      super("회원관리");
     
      add("North", mainNorthPane);
         for(int idx=0; idx<lbl.length; idx++) { //폼의라벨
            JLabel formLabel = new JLabel(lbl[idx]);
            formLabelPane.add(formLabel);
         }
         mainNorthPane.add("West", formLabelPane);
         
         //TextField
         for(int idx=0; idx<tf.length; idx++) {
            JPanel p = new JPanel();
            p.setLayout(new FlowLayout(FlowLayout.LEFT));
            p.add(tf[idx]);
            formCenterPane.add(p);
         }
         
      add("Center", mainCenterPane);
         mainNorthPane.add("Center", formCenterPane);
         
         //버튼
         for(int idx=0; idx<btnLbl.length; idx++) {
            JButton btn = new JButton(btnLbl[idx]);
            buttonPane.add(btn);
            btn.setBackground(Color.lightGray);
     
            //이벤트 등록
            btn.addActionListener(this);
         }
         mainCenterPane.add("North", buttonPane);
         
         //JTable 객체 생성
         model = new DefaultTableModel(lbl, 0);
         table = new JTable(model);
         sp = new JScrollPane(table);
         mainCenterPane.add("Center", sp);
         
      //검색
      add("South", searchPane);
         searchPane.add(searchTf);
         searchPane.add(searchBtn);
      //기본세팅
      setSize(1000,600);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);   
      
      searchBtn.addActionListener(this);
      table.addMouseListener(new MouseAdapter(){
         public void mouseReleased(MouseEvent me) {
            //이벤트 발생 버튼이 마우스 왼쪽 버튼이면
        	if(me.getButton()==1) {
            	//선택된 행번호 가져오기
        		int row = table.getSelectedRow();
        		int col = table.getColumnCount();
        		for(int c=0; c<col; c++) {
        			if(c==0) {//숫자일때
        				tf[c].setText(String.valueOf(model.getValueAt(row, c)));
        			}else {//문자일때
        				tf[c].setText((String)model.getValueAt(row, c));
        			}
        		}
            }
         }
      });
      
      //초기화면에 회원전체 목록 보여야함
      getMemberAll();
   }
   //이벤트 처리 메소드
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("Search")) {
    	  memberSearch();
      }else if(eventBtn.equals("전체목록")) {
    	  getMemberAll();
      }else if(eventBtn.equals("추가")) {
    	  setMember();
      }else if(eventBtn.equals("지우기")) {
    	  setFormClear();
      }else if(eventBtn.equals("종료")) {
    	  System.exit(0);
    	  //자원해제(Window클래스)
    	  dispose();
      }else if(eventBtn.equals("수정")) {
    	  setMemberUpdate();
      }else if(eventBtn.equals("삭제")) {
    	  setMemberDelete();
      }else if(eventBtn.equals("엑셀로쓰기")) {
    	  setMemberExcelSave();
      }else if(eventBtn.equals("엑셀에서가져오기")) {
    	  getMemberExcelOpen();
      }
   }
   //엑셀에서 회원목록 가져오기
   public void getMemberExcelOpen() {
	   JFileChooser fc = new JFileChooser();
	   FileFilter ff = new FileNameExtensionFilter("*.xls", "xls","XLS");
	   fc.setFileFilter(ff);
	   
	   //0:열기, 1:취소
	   int state = fc.showOpenDialog(this);
   
	   if(state==0) {
		   try {
			   //선택해놓은 파일정보
			   File selectFileName = fc.getSelectedFile();
			   FileInputStream fis = new FileInputStream(selectFileName);
		  
			   //엑셀에서 파일 사용할 수 있는 객체를 생성한다.
			   POIFSFileSystem poi = new POIFSFileSystem(fis);
			   
			   //workbook
			   HSSFWorkbook workbook = new HSSFWorkbook(poi);
			   
			   //sheet
			   HSSFSheet sheet = workbook.getSheet("회원정보");
			   
			   //row				행의 수 구하기
			   int rowCount = sheet.getPhysicalNumberOfRows();
			   // idx 0번째행은 필드명이므로 row의 시작값을 1로 준다.
			   
			   List<UserVO> lst = new ArrayList<UserVO>();
			   
			   for(int row=1; row<rowCount; row++) {
				   //cell
				   UserVO vo = new UserVO();
				   
				   HSSFRow rowData= sheet.getRow(row);
				   
				   //번호								  double형으로 cell데이터 가져오기
				   vo.setNum((int)rowData.getCell(0).getNumericCellValue());
				   vo.setUsername(rowData.getCell(1).getStringCellValue()); //String
				   vo.setTel(rowData.getCell(2).getStringCellValue());
				   vo.setEmail(rowData.getCell(3).getStringCellValue());
				   vo.setAddr(rowData.getCell(4).getStringCellValue());
				   vo.setWritedate(rowData.getCell(5).getStringCellValue());
				   lst.add(vo);
			   }
			   
			   setNewTableList(lst);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
   }
   //엑셀 파일로 쓰기
   public void setMemberExcelSave() {
	   //파일탐색기
	   JFileChooser fc = new JFileChooser();
	   
	   FileFilter ff = new FileNameExtensionFilter("*.xls", "xls","XLS");
	   fc.setFileFilter(ff);
	   
	   int state = fc.showSaveDialog(this);
	   
	   if(state==0) {//파일 탐색기에서 저장 버튼을 선택시
		  //선택한 위치와 파일명을 얻어오기
		  File selFile = fc.getSelectedFile();
		  
		  //엑셀객체만들기
		  HSSFWorkbook workbook = new HSSFWorkbook();
		  HSSFSheet sheet = workbook.createSheet("회원정보");
		  
		  //제목
		  HSSFRow row = sheet.createRow(0);
		  //row.createCell(0).setCellValue("번호");
		  //row.createCell(1).setCellValue("이름");
		  //row.createCell(2).setCellValue("연락처");
		  for(int i=0; i<lbl.length; i++) {
			  row.createCell(i).setCellValue(lbl[i]);
		  }
		  //JTable의 행의 수
		  int rowCount = table.getRowCount();
		  for(int i=0; i<rowCount; i++) {
			  HSSFRow r = sheet.createRow(i+1);
			  //칸수
			  int c = table.getColumnCount();
			  for(int j=0; j<c; j++) {
				  if(j==0) {//번호
					  r.createCell(j).setCellValue((int)table.getValueAt(i, j));
				  }else{//번호 아닐때
					  r.createCell(j).setCellValue((String)table.getValueAt(i, j));
				  }
			  }
		  }
		  //만들어진 엑셀파일을 파일로 쓰기(저장)
		  try {
			  FileOutputStream fos = new FileOutputStream(selFile);
			  workbook.write(fos);
			  if(fos!=null) fos.close();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
	   }
   }
   //회원정보 삭제
   public void setMemberDelete() {
	   int num = Integer.parseInt(tf[0].getText()); //삭제할 레코드 번호
	   UserDAO dao = new UserDAO();
	   int result = dao.memberDelete(num);
	   String msg = "회원정보가 삭제되었습니다.";
	   if(result>0) {
		  getMemberAll();
	   }else {
		  msg = "회원정보 삭제실패하였습니다.";
	   }
	   setFormClear();
	   JOptionPane.showMessageDialog(this, "회원정보가 삭제되었습니다.");
	}
   //회원정보 수정
   public void setMemberUpdate() {
	   UserVO vo = new UserVO();
	   vo.setNum(Integer.parseInt(tf[0].getText()));//번호
	   vo.setTel(tf[2].getText());//연락처
	   vo.setEmail(tf[3].getText());//이메일
	   vo.setAddr(tf[4].getText());//주소
	   
	   UserDAO dao = new UserDAO();
	   int result = dao.memberUpdate(vo);
	   if(result>0) {
		  JOptionPane.showMessageDialog(this, "회원정보가 수정되었습니다.");
		  getMemberAll();
		  setFormClear();
	   }else {
		  JOptionPane.showMessageDialog(this, "회원정보 수정실패하였습니다.");
	   }
   }
   //폼의 값 초기화
   public void setFormClear() {
	   for(int i=0; i<tf.length; i++) {
		   tf[i].setText("");
	   }
   }
   //회원 등록
   public void setMember() {
	   //텍스트필드의 데이터를 VO에 셋팅
	   UserVO vo = new UserVO(tf[1].getText(), tf[2].getText(), tf[3].getText(), tf[4].getText());
	  
	   //이름과 연락처가 있을때만 데이터베이스에 추가한다.
	   if(vo.getUsername().equals("") || vo.getTel().equals("")) {
		   JOptionPane.showMessageDialog(this, "이름과 연락처는 반드시 입력하여야 합니다.");
	   }else if(vo.getUsername().length()>4){
		   JOptionPane.showMessageDialog(this, "이름은 4글자 이하로 작성하여야 합니다.");
	   }else {
		   UserDAO dao = new UserDAO();
		   int result = dao.memberInsert(vo);
		   if(result>0) {//회원등록 완료
			   JOptionPane.showMessageDialog(this, "회원이 등록되었습니다.");
			   getMemberAll();
			   setFormClear();
		   }else {//회원등록 실패
			   JOptionPane.showMessageDialog(this, "회원등록이 실패하였습니다.");
		   }
	   }
   }
   //회원 검색
   public void memberSearch() {
	   //검색어에 입력된 데이터
	   String searchWord = searchTf.getText();
	   if(searchWord.equals("")) {//검색어가 없을때
		   JOptionPane.showMessageDialog(this, "검색어를 입력후 검색하세요");
	   }else {//검색어가 있을때
		   UserDAO dao = new UserDAO();
		   List<UserVO> searchList = dao.getSearchRecord(searchWord);
		   
		   if(searchList.size()==0) { //검색조건의 회원이 없을경우
			   JOptionPane.showMessageDialog(this, searchWord+"의 검색결과가 존재하지 않습니다.");
		   }else {// 있을경우
			   setNewTableList(searchList);
		   }
		   searchTf.setText("");
	   }
   }
   //회원전체 선택
   public void getMemberAll() {
      //데이터베이스의 모든 회원을 선택해서 JTable에 표시한다
      
	   UserDAO dao = new UserDAO();
	   List<UserVO> lst = dao.memberAllSelect();
	   
	   setNewTableList(lst);
   }
   public void setNewTableList(List<UserVO> lst) {
	   model.setRowCount(0); //JTable의 모든 레코드 지우기
	   for(int i=0; i<lst.size(); i++) {
		   UserVO vo = lst.get(i);
		   Object[] data = {vo.getNum(), vo.getUsername(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWritedate()};
		   model.addRow(data);
	   }
   }
   public static void main(String[] args) {
      new UserManagementMain();
   }

}