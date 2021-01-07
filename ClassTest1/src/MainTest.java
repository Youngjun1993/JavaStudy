public class MainTest
{
	public static void main(String[] args) 
	{
		if(args[0].equals("swan") && args[1].equals("1234")){
			System.out.println("로그인 성공");
		}else{
			System.out.println("로그인 실패");
		}
		// 상단메뉴 run -> run configuration -> Arguments ->  program arguments : swan 1234 입력해야 실행됨
	}
}
