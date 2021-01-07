
public class VariableTest {

	public static void main(String[] args) {
		Aclass aaa = new Aclass(100, "순신");
		/*
		    aaa라는 래퍼런스 변수에 Aclass 객체를 생성했을때 가져오는것
		 	num = 100
		 	username = 순신
		 	scan
		 	total()
		 	sum()
		 */
		
		
		// 객체내의 num와 username이 변경이 되었는지 확인한다.
		// 객체명.변수명
		System.out.println("aaa.num->" + aaa.num);
		
		Aclass bbb = new Aclass();
		/*
	    bbb라는 생성자 변수에 Aclass 객체를 생성했을때 가져오는것
	 	num = 500
	 	username = 홍길동
	 	scan
	 	total()
	 	sum()
		 */
	}

}
