//이영준
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PackManEX extends JFrame{
	Image img;
	MyCanvas mc = new MyCanvas();
	JTextArea ta = new JTextArea();
	
	int x = 200;
	int y = 200;
	int imgCutx;
	int imgCuty;
	int xmove = 0;
	int ymove = 0;
	int imgCutx2, imgCuty2;
	
	public PackManEX() {
		pack();
		add(ta);
		add("Center",mc);
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//자동 초기값
		xmove = -5;
		imgCutx = 0;
		imgCuty = 50;
		System.out.println(mc.getSize());
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				char evtChar = ke.getKeyChar();
				int evtInt = ke.getKeyCode();
				if(evtInt == KeyEvent.VK_A) {
					xmove = -5;
					ymove = 0;
					if(x%2!=0) {
						imgCutx = 0;
						imgCuty = 50;
					} else {
						imgCutx = 0;	
						imgCuty = 50;
					}
				}else if(evtInt == KeyEvent.VK_D) {
					xmove = +5;
					ymove = 0;
					if(x%2!=0) {
						imgCutx = 100;
						imgCuty = 150;
					} else {
						imgCutx = 100;	
						imgCuty = 150;
					}
				}else if(evtInt == KeyEvent.VK_W) {
					xmove = 0;
					ymove = -5;
					if(y%2!=0) {
						imgCutx = 200;
						imgCuty = 250;
					} else {
						imgCutx = 200;	
						imgCuty = 250;
					}
				}else if(evtInt == KeyEvent.VK_S) {
					xmove = 0;
					ymove = +5;
					if(y%2!=0) {
						imgCutx = 300;
						imgCuty = 350;
					} else {
						imgCutx = 300;	
						imgCuty = 350;
					}
				}
			}
		}); 
		Start();
	}
	public void Start() {
		while(true) {
				mc.repaint();
				x += xmove;
				y += ymove;
				if(x%2!=0 || y%2!=0) {
					imgCutx2 = imgCutx;
					imgCuty2 = imgCuty;
				} else {
					imgCutx2 = imgCutx+50;	
					imgCuty2 = imgCuty+50;
				}
				try {
					Thread.sleep(200);
				}catch(Exception e) {}
			}
	}
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		public void paint(Graphics g) {	
			//이미지
			g.drawImage(img, x, y, x+50, y+50, imgCutx2, 0, imgCuty2, 50, this);
		}
	}
	public static void main(String[] args) {
		new PackManEX();
	}

}
