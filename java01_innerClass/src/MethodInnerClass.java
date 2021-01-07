
public class MethodInnerClass {
	String email = "abcd@nate.com";
	public MethodInnerClass() {

	}
	public void output() {
		System.out.println("이메일==>"+email);
	}
	public void innerClassMethod() {
		int num = 100;
		//메소드에 정의된 내부 클래스
		class InnerCreate{
			String name = "홍길동";
			InnerCreate(){
				
			}
			void innerPrint() {
				System.out.println("name--->"+name);
				System.out.println("num--->"+num);
				System.out.println("email--->"+email);
				output();
			}
		}
		
		//객체생성
		InnerCreate ic = new InnerCreate();
		ic.innerPrint();
		
	}
	public static void main(String[] args) {
		new MethodInnerClass().innerClassMethod();
		
	}

}
