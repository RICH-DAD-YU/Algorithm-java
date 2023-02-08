package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {

	static int T;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
				
		for (int i = 0; i < T; i++) {
			
			Stack<Character> stack = new Stack<Character>();
			
			String str = br.readLine();
			int strLength = str.length();
			
			for (int j = 0; j < strLength; j++) {
				// ( 문자일 경우 stack에 push
				if(str.charAt(j) == '(') {
					stack.push('(');
				// ) 문자일 경우 stack.peek이 ( 라면 stack.pop
				// 단, stack size가 0일 경우 그냥 push
				}else {
					if(stack.size() == 0) stack.push(')');
					char tmp = stack.peek();
					if(tmp == '(') {
						stack.pop();
					}
				}
			}
			// stack에 남아 있는 것이 없다면 YES, 무언가 남아 있다면 NO
			if(stack.size() == 0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
