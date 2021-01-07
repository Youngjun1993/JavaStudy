import java.util.Arrays;
import java.util.Scanner;
// 이영준

public class LottoGame {
	/*
	 	난수의 숫자 중복 제거
	 	오름차순 정렬
	 	게임수 입력한 만큼 배열 생성
	 	재실행
	 */
	Scanner sc = new Scanner(System.in);
	public LottoGame() {
		
	}
	public void lottoGame() {
		System.out.print("게임수=");
		int count = sc.nextInt();
		int numArr[] = new int[6];
		int ranNum = 0;
		int bonus = 0;
		int temp;
		
		// 난수입력
		for(int i=0; i<count; i++) {
			ranNum = (int)(Math.random()*45)+1;
			bonus = ranNum;
			for(int j=0; j<numArr.length; j++) {
				ranNum = (int)(Math.random()*45)+1;
				numArr[j]=ranNum;
				// 중복제거
				for(int k=0; k<j; k++) {
					if(numArr[j] == numArr[k]) {
						j--;
					}
				}
			}
			// 배열 정렬
			for(int i2=0;i2<numArr.length-1;i2++) {
				for(int j2=i2+1; j2<numArr.length;j2++) {
					if(numArr[i2] > numArr[j2]) {
						temp = numArr[i2];
						numArr[i2] = numArr[j2];
						numArr[j2] = temp;
					}
				}
			}
			// 보너스 중복제거
			for(int idx=0;idx<numArr.length;idx++) {
				for(int idx2=0; idx2<idx; idx2++) {
					if(numArr[idx] == bonus) {
						ranNum = (int)(Math.random()*45)+1;
						bonus = ranNum;
						idx--;
					}
					continue;
				}
			}
			// 출력
			System.out.println(i+1+"게임="+Arrays.toString(numArr)+", bonus=" + bonus);
		}
	}
	
	// 재시작 메소드
	public void restart() {
		while(true) {
			System.out.print("계속하시겠습니까(1:예, 2:아니오)?");
			int reStartNum = sc.nextInt();
			if(reStartNum == 1) {
				this.lottoGame();
			}
			else if(reStartNum == 2) {
				break;	
			}
			else{
				System.out.print("제대로 입력하세요ㅡㅡ...(1, 2)");
				reStartNum = sc.nextInt();
				if(reStartNum == 1) {
					this.lottoGame();
				}
				else {
					break;
				}
			}
		}
	}
	
	// main 메소드
	public static void main(String[] args) {
		LottoGame lg = new LottoGame();
		lg.lottoGame();
		lg.restart();
	}

}
