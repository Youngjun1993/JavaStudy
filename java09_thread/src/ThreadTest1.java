
//1. Thread 클래스 상속
public class ThreadTest1 extends Thread{
	String title;
	public ThreadTest1(String title) {
		this.title = title;
	}
	public ThreadTest1() {}
	// 2. run()메소드 오버라이딩
	public void run() {
		//무한루프
		for(int i=1;;i++) {
			System.out.println(title+"="+i);
			try {Thread.sleep(500);}catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		//객체생성하면서 호출된 메소드로인해 무한루프가 걸려 아래 tt2는 생성되지 못하고 있다.
		ThreadTest1 tt1 = new ThreadTest1("첫번째 스레드");
		ThreadTest1 tt2 = new ThreadTest1("두번째 스레드");
		
		// 3. 스레드 등록
		// Thread 클래스에 있는 start()메소드를 선언해 스레드 등록
		tt1.start();
		tt2.start();
	}

}
