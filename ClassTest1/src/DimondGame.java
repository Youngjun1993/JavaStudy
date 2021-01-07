import java.util.Scanner;
// 이영준
public class DimondGame {
	Scanner scan = new Scanner(System.in);
	int line;
	public DimondGame() {}
	// 입력
	public void input() {
		System.out.print("임의의 홀수입력(1~49)=");
		line = scan.nextInt()/2;
		dimond();
	}
	// 계산
	public void dimond() {
		int aa = 65;
		// 상단
		for(int i=1; i<=line+1; i++) {
			for(int j=line-i; j>=0; j--) {
				System.out.print(" ");
			}
			for(int j=1; j<i*2; j++) {
				System.out.print((char)aa);
				// 알파벳 증가
				aa++;
				// A~Z까지만 반복
				if(aa > 90) {
					aa = 65;
				}
			}
			System.out.println("");
		}
		// 하단
		for(int i=1; i<=line; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=line*2; j>i*2-1; j--) {
				System.out.print((char)aa);
				// 알파벳 증가
				aa++;
				// A~Z까지만 반복
				if(aa > 90) {
					aa = 65;
				}
			}
			System.out.println("");
		}
	}
	// main 메소드
	public static void main(String[] args) {
		new DimondGame().input();
	}
}
