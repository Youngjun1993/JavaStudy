//1. Runnable 인터페이스 상속
public class ThreadTest2 implements Runnable{
	String title;
	public ThreadTest2() {
		
	}
	public ThreadTest2(String title) {
		this.title = title;
	}
	//2.스레드 구현 코드를 run()에 구현
	public void run() {
		int i=1;
		while(true) {
			try {Thread.sleep(300);}catch(Exception e) {}
			System.out.printf("%s-->i=%d\n",title,i++);
		}
	}
	public static void main(String[] args) {
		ThreadTest2 tt1 = new ThreadTest2("첫번째 스레드");
		ThreadTest2 tt2 = new ThreadTest2("두번째 스레드");
		ThreadTest2 tt3 = new ThreadTest2("세번째 스레드");
		
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);
		Thread t3 = new Thread(tt3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
