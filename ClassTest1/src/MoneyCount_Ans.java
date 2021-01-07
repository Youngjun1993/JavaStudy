import java.util.Scanner;

public class MoneyCount_Ans {
	Scanner scan = new Scanner(System.in);
	int money[] = {50000,10000,5000,1000,500,100,50,10,5,1};
	
	public MoneyCount_Ans() {
		
		System.out.print("금액입력=");
		int wonInt = scan.nextInt();
		
		for(int i=0; i<money.length; i++) {
			int cnt = wonInt/money[i];
			if(cnt>0) {
				System.out.println(money[i] + "원=" + cnt);
				if(money[i]>=1000) {
					System.out.print("장");
				}else {
					System.out.print("개");
				}
				wonInt -= (cnt*money[i]); //차액계산
			}
		}
	}

	public static void main(String[] args) {
		new MoneyCount_Ans();
	}

}
