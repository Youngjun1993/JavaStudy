package pac;

public class Access2 {
	private int num = 100;
	String name = "홍길동";
	
	 public Access2() {
		
	}
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 //getter ,  setter
	 public int getNum() {
		 return this.num;
	 }
	 public void setNum(int num) {
		 //기능구현(이렇게나눠서 곱셈 나눗셈등 그떄그떄 주어지게하고 연산이가능함)
		 this.num = num;
	 }
}
