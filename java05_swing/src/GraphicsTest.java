import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{
	MyCanvas mc = new MyCanvas();
	public GraphicsTest() {
		setTitle("그림판");
		add(BorderLayout.CENTER, mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	//그림그리기
	//Canvas를 상속받아 paint()를 오버라이딩하면 처음 객체생성시 별도의 호출없이
	//		   paint()메소드는 1번 자동호출된다.
	class MyCanvas extends Canvas{
		public MyCanvas() {}
		//그림을 그리는 메소드를 오버라이딩한다. --> 생성자메소드 실행 후 자동호출됨.
		public void paint(Graphics g) {
			//직선그리기
			g.drawLine(50,50,300,300);
			//사각형그리기
			g.drawRect(80, 50, 200, 300);
			//색상 변경(그리기전에 할것)
			g.setColor(Color.red);
			g.fillRect(400, 50, 200, 300);
			
			//글자 그리기
			g.setColor(Color.blue);
			g.setFont(new Font("굴림",Font.BOLD,30));
			String str = "문자열을 그림으로 그리기";
			g.drawString(str, 50, 400);
			
			//원그리기
			g.drawOval(80, 50, 200, 300);
			g.fillOval(400, 50, 200, 300);
			
			//둥근원
			g.setColor(Color.DARK_GRAY);
			g.drawRoundRect(250, 450, 400, 400, 200, 200);
			
			//다각형
			g.setColor(Color.GREEN);
			int x[] = {300, 400, 350, 100, 110};
			int y[] = {100, 180, 400, 600, 300};
			g.drawPolygon(x, y, x.length);
		}
	}
	public static void main(String[] args) {
		new GraphicsTest();
	}

}
