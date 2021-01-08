import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {
	//객체를 이용한 컨테이너 생성
	Frame frm = new Frame();
	Dimension dim = new Dimension(300,300);
	Point pnt = new Point(200,200);
	Rectangle rect = new Rectangle(pnt, dim);
	public FrameTest() {
		frm.setTitle("연습용 Frame");
		
		// 창의 크기설정
		//frm.setSize(500, 500); // width, height
		//frm.setSize(dim); // Dimension이 가지고 있는 창의 크기로 설정
		
		//frm.setBounds(100,100,500,500); // x, y, width, height
		frm.setBounds(rect); // Rectangle이 가지고 있는 창의 크기로 설정
		
		//frm.pack(); // 설정값이 없어서 아무것도 안나온다.
		
		// show 하기전에 컨포넌트 기능을 설정해야된다.
		Button btn1 = new Button("버튼1");
		frm.add(btn1);
		
		Button btn2 = new Button("버튼2");
		//		BorderLayout.NORTH
		frm.add(BorderLayout.NORTH, btn2);
		//frm.add("North",btn2); // 위와 같다.
		frm.add(BorderLayout.EAST, new Button("버튼3"));
		frm.add(BorderLayout.SOUTH, new Button("버튼4"));
		frm.add(BorderLayout.WEST, new Button("버튼5"));
		
		// 창을 show
		frm.setVisible(true);
		// 크기설정(setSize,Bounds), 창보여주기(setVisible)까지 무조건 세팅이 되어야 화면에 보여질것.
		
		// 컨테이너 상단바 실행 아이콘 설정
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/common.jpg");
		frm.setIconImage(img);
		
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}
