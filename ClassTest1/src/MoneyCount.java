import java.util.Scanner;

// 이영준
public class MoneyCount {
	int money;
	
	public MoneyCount() {
		
	}
	
	// 금액 입력
	public int money(String input) {
		Scanner sc = new Scanner(System.in);
		System.out.print(input + "=");
		return money = sc.nextInt();
	}
	
	// 거스름돈 출력
	public void countMoney() {
		int payback[] = {50000,10000,5000,1000,500,100,50,10,1};
		for(int i=0; i<payback.length; i++) {
			if(money / payback[i] == 0) {	// 입력값과 인덱스 i번째를 나눴을때 0이면 그냥 넘어간다.
				continue;
			}
			else if(payback[i] <= 500){		// 인덱스 i번째가 500보다 작거나 같으면 "개"를 출력
				System.out.println(payback[i]+"원="+(money / payback[i])+"개");
				money = money % payback[i];
			}
			else{							// 나머지는 "장"으로 출력
				System.out.println(payback[i]+"원="+(money / payback[i])+"장");
				money = money % payback[i];
			}
		}
	}
	
	// main 메소드
	public static void main(String[] args) {
		MoneyCount mc = new MoneyCount();
		mc.money("금액을 입력하세요?");
		mc.countMoney();
	}

}
