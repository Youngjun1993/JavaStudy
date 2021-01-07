import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

//implements는 클래스에서 인터페이스를 상속받을때
//				인터페이스는 여러개를 상속받을 수 있다.
// 				상속받은 모든 추상메소드를 오버라이딩해야한다.
public class InterfaceMain implements InterfaceTest, ActionListener{
	public InterfaceMain() {}
	//추상메소드 오버라이딩
	public void print() {
		System.out.println(global+"-->"+MAX);
	}
	public int[] recordAll(int num) {
		Random r = new Random();
		int ran[] = new int[num];
		for(int i=0; i<ran.length; i++) {
			ran[i] += r.nextInt(100);
		}
		return ran;
	}
	public String total(int max) {
		return "";
	}
	public double getData(int data) {
		return (double)data;
	}
	public void actionPerformed(ActionEvent e) {}
	
	public static void main(String[] args) {
		InterfaceMain im = new InterfaceMain();
		im.print();
		int n[] = im.recordAll(5);
		System.out.println(Arrays.toString(n));
	}
	

}
