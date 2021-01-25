
public class MultiPackMan {

	public MultiPackMan() {}

	public static void main(String[] args) {
		PackMan pm1 = new PackMan(1,1,500,500);
		PackMan pm2 = new PackMan(501,1,500,500);
		PackMan pm3 = new PackMan(1,501,500,500);
		PackMan pm4 = new PackMan(501,501,500,500);
		
		Thread t1 = new Thread(pm1);
		Thread t2 = new Thread(pm2);
		Thread t3 = new Thread(pm3);
		Thread t4 = new Thread(pm4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
