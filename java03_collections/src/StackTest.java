import java.util.Stack;

public class StackTest {

	public StackTest() {
		// FILO : 먼저 추가된 객체가 제일 마지막에 output된다.
		// First In Last Out
		Stack<Integer> stack = new Stack<Integer>();
	
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
			System.out.println("남은객체수-->"+stack.size());
		}
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
