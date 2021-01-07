import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoColletion {
	Scanner sc = new Scanner(System.in);
	public LottoColletion() {}
	public void start() {
		do {
			int cnt = gameCount();//게임수
			for(int i=1; i<=cnt; i++) {
				System.out.print(i+"게임=");
				createLotto();
			}
			// true:계속, false:중지
			if(!qna()) {
				break;
			}
		}while(true);
		System.out.println("------------ The End ------------");
	}
	//게임수 입력
	public int gameCount() {
		int intCnt = 0;
		do {
			try {
				System.out.print("게임수=");
				intCnt = Integer.parseInt(sc.nextLine());	// 문자가 들어온다면 Error
				//게임의 수가 양수가 아닐 경우 게임수 재입력처리
				if(intCnt <= 0) {
					//강제 예외 발생  throw new Exception(메세지)
					throw new Exception("게임수는 1보다 큰값이여야 합니다..");
				}
				break; // 게임수가 입력되었을때
			}catch(NumberFormatException ne) {
				System.out.println("게임수는 정수만 입력하여야 합니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		return intCnt;
	}
	//로또 1게임 만드는 메소드
	public void createLotto() {
		Random ran = new Random();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lastNum = 0;
		// 생성 후 -> TreeSet에 추가 -> 7개가 될때까지
		while(true) {
			lastNum = ran.nextInt(45)+1; // 1~45 -- 마지막으로 만들어진 번호
			ts.add(lastNum);
			if(ts.size() >= 7) break;
		}
		// 마지막으로 생성된 번호는 보너스임으로 TreeSet에서 제거한다.
		ts.remove(lastNum);
		System.out.print(ts.toString()); // [5,12,34,56,88,55]
		System.out.println(", bonus="+lastNum);
	}
	// 계속여부 확인	true:계속, false:중지
	public boolean qna() {
		boolean boo = false;
		do {
			System.out.print("계속하시겠습니까(Y or y:예, N or n:아니오)?");
			String que = sc.nextLine();
			// 대소문자 구분없이 찾는다 : equalsIgnoreCase
			if(que.equalsIgnoreCase("Y")) { // "Y".equalsIgnoreCase(que)와 같다.
				boo = true;
				break;
			}else if(que.equalsIgnoreCase("N")){
				boo = false;
				break;
			}else {
				System.out.println("Y or N을 입력하세요...");
			}
		}while(true);
		return boo;
	}
	public static void main(String[] args) {
		LottoColletion lotto = new LottoColletion();
		lotto.start();
	}

}
