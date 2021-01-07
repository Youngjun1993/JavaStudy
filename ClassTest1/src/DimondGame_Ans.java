import java.util.Scanner;

public class DimondGame_Ans {
	Scanner scan = new Scanner(System.in);
	public DimondGame_Ans() {
		
	}
	public void start() {
		//입력받기
		System.out.print("임의의 홀수입력(1~49)=");
		int max = scan.nextInt();
		//짝수가 입력되면 홀수로 변경한다.
		if(max%2==0) max--;
		
		//출력할 문자의 초기값
		char txt = 'A';
		
		//행(삼각형)
		for(int row=1; row<=max; row+=2) {	// row=1,3,5,7,9
			//공백
			for(int space=1; space<=(max-row)/2; space++) {	// space=1,2,3,4
				System.out.print(" ");
			}
			//문자출력
			for(int col=1; col<=row; col++) {
				System.out.print(txt++);
				if(txt>'Z') {
					txt = 'A';
				}
			}
			System.out.println("");
		}
		//역삼각형
		for(int row=max-2; row>=1; row-=2) {
			//공백
			for(int space=1; space<=(max-row)/2; space++) {
				System.out.print(" ");
			}
			//문자
			for(int col=1; col<=row; col++) {
				System.out.print(txt++);
				if(txt>'Z') {
					txt = 'A';
				}
			}
			//줄바꿈
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		new DimondGame_Ans().start();;
	}
	

}
