import java.util.Scanner;

public class StandardWeight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("성별(1:남성,2:여성) = ");
		int gender = sc.nextInt();
		
		System.out.print("키 = ");
		int height = sc.nextInt();
		
		System.out.print("체중 = ");
		double weight = sc.nextInt();
		
		// 표준체중 구하기
		double standardWeight = 0.0;
		switch(gender) {
			case 1:
				if(age <= 35) {
					standardWeight = (height - 100)*0.90;
				}else if(age >= 36) {
					standardWeight = (height - 100)*0.95;
				}
				break;
			case 2:
				if(age <= 35) {
					standardWeight = (height - 100)*0.85;
				}else if(age >= 36) {
					standardWeight = (height - 100)*0.90;
				}
		}
		
		// 표준체중 지수 구하기
		double stanWeiVal = (weight/standardWeight) * 100;
		String stanWeiStr = "";
		
		// 표준체중지수 평가기준 구하기
		if(stanWeiVal <= 85) {
			stanWeiStr = "마른형";
		}else if(stanWeiVal >= 86 && stanWeiVal <= 95) {
			stanWeiStr = "조금마른형";
		}else if(stanWeiVal >= 96 && stanWeiVal <= 115) {
			stanWeiStr = "표준형";
		}else if(stanWeiVal >= 116 && stanWeiVal <= 125) {
			stanWeiStr = "조금 비만형";
		}else if(stanWeiVal >= 126) {
			stanWeiStr = "비만형";
		}
		
		// 표준체중 및 지수 화면 출력
		System.out.println("표준체중 = " + (int)standardWeight);
		System.out.println("당신은 표준체중지수는 " + stanWeiVal + "으로 " + stanWeiStr + "입니다.");
		
	}

}
