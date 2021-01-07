package apiClass;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {

	public ArraysTest() {
		int data[] = {58,62,4,95,31,75,15,27,45,79,12};
		int data2[] = {58,62,4,95,31,75,15,27,45,79,12};
		// 배열객체의 데이터를 크기순으로 정렬
		Arrays.sort(data);	// 오름차순으로 정렬
		System.out.println("오름차순="+Arrays.toString(data));
		Arrays.sort(data2, 1, 5);	// index 1부터 5앞까지 정렬
		System.out.println("1부터 5앞까지만 정렬="+Arrays.toString(data2));
		
		int data3[] = Arrays.copyOfRange(data, 1, 5);// index 1부터 5앞까지 복사
		System.out.println("copyOfRange="+Arrays.toString(data3));
		
		int data4[] = Arrays.copyOf(data, 5);
		System.out.println("copyof="+Arrays.toString(data4));
		
		///arraycopy(Object src, int srcPos, Object dest, int destPos,int length)
		int data5[] = new int[20];
		// data배열의 index 5인 위치의 값부터 data4의 index 3의 위치에 6개를 복사하라.
		System.arraycopy(data, 5, data5, 3, 6);
		System.out.println("arraycopy->"+Arrays.toString(data5));
		
	}

	public static void main(String[] args) {
		new ArraysTest();
	}

}
