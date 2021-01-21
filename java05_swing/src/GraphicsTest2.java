import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicsTest2 extends JFrame{
	MyCanvas mc = new MyCanvas();
	public GraphicsTest2() {
		add(mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		while(true) {
			mc.repaint();
			//일시정지
			try{
				//1초 일시정지
				Thread.sleep(1000);
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	public class MyCanvas extends Canvas{
		Random ran = new Random();
		public void paint(Graphics g) {
			int x = ran.nextInt(700);
			int y = ran.nextInt(700);
			g.fillOval(x, y, 10, 10);
		}
		//repaint 이후 한번 거처가는 메소드 (update)
		public void update(Graphics g) {
			paint(g);
		}
	}
	public static void main(String[] args) {
		new GraphicsTest2();
	}

}
