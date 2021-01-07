package apiClass;

import java.util.Random;

public class RandomTest {

	public RandomTest() {
		start();
	}
	public void start() {
		//Random : 난수 클래스
		Random ran = new Random();
		for(int i=1;i<1000;i++) {
			//boolean result = ran.nextBoolean();//논리형 : true, false
			//double result = ran.nextDouble();
			int result = ran.nextInt();
			result = ran.nextInt(100);	// 100-> 0~99
			result = ran.nextInt(31)+10;	// 10~40-> 난수*(큰수-작은수+1)+작은수
			result = ran.nextInt(60)+1;	// 1~60 정수
			
			System.out.print(result +"\t");
			if(i%10==0) System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new RandomTest();
	}

}
