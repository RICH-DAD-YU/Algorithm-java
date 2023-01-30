package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 좋은단어_3986 {

	static int N; // 단어의 수
	static char[] array; // 단어를 담을 배열

	// 현재 넣을 문자와 stack 꼭대기의 문자를 비교하여 같으면 pop, 다르면 push
	// 최종적으로 stack이 비어져 있으면 좋은 단어
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			
			Stack<Character> stack = new Stack<Character>();
			String str = br.readLine();
			array = str.toCharArray();
			
			stack.push(array[0]);
			for (int j = 1; j < array.length; j++) {
				if(stack.size() == 0) {
					stack.push(array[j]);
				}else if(stack.peek() == array[j]) {
					stack.pop();
				}else {
					stack.push(array[j]);
				}
			}
			if(stack.size() == 0) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
