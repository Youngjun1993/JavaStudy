import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
         String btnLbl[] = {"전체목록","추가","수정","삭제","지우기","종료","엑셀로쓰기","엑셀에서가져오기0"};
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
            
         }
      });
      
      //초기화면에 회원전체 목록 보여야함
      getMemberAll();
   }
   
   public void actionPerformed(ActionEvent ae) {
      String eventBtn = ae.getActionCommand();
      if(eventBtn.equals("Search")) {
    	  memberSearch();
      }else if(eventBtn.equals("전체목록")) {
    	  getMemberAll();
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