// 인터페이스 -> 인터페이스 상속
public interface InterfaceTest extends InterfaceTest2 {
	// static 멤버변수들
	public static String global = "seoul";
	public static final int MAX = 100;	// final을 붙여 상수화(값을 변경할수 없다)된 변수를 만듬.
	// 추상메소드들
	public void print();
	public int[] recordAll(int num);
	public String total(int max);
}
