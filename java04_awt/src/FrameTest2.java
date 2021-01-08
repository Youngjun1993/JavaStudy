import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameTest2 extends Frame{

	public FrameTest2() {
		super("상속받은 프레임"); // 창제목	setTile("창제목:);
		
		
		//레이아웃 변경 BorderLayout -> FlowLayout으로 변경
		setLayout(new FlowLayout());
		
		Button btn = new Button("레이아웃변경됨");
		add(btn);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FrameTest2();
	}

}
