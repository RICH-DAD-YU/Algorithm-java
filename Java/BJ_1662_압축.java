package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 압축_1662 {
	
	static int[] array;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int strLength = str.length();
		
		array = new int[strLength];
		
		Stack<Node> stack = new Stack<Node>();
		
		int ans = 0;
		int abs = 0;
		
		for (int i = 0; i < strLength; i++) {
			
			int idx = i;
			char ch = str.charAt(i);
			
			Node node = new Node(idx, ch);
			
			int cnt = 0; // 괄호 안에 숫자 갯수
			if(ch == ')') {
				abs = idx;
				while(true) {
					Node node1 = stack.pop();
					
					int tmpidx = node1.idx;
					int tmpch = node1.ch;
					
					if(tmpch == '('){
						for (int j = tmpidx; j <= i; j++) {
							if(array[j] != 0) {
								cnt += array[j];
								array[j] = 0;
							}
						}
						break;
					}
					cnt++;
				}
				
				int front = stack.pop().ch - '0'; // 괄호 앞에 있는 계수 느낌
				
				ans = (cnt * front);
				array[i] = ans;
				
			}else {
				stack.push(node);
			}
		}
		if(stack.size() != 0) {
			ans += stack.size();
		}
		
		for (int i = 0; i < strLength-1; i++) {
			if(array[i] != 0) {
				if(i == abs) continue;
				ans += array[i];
			}
		}
		
		System.out.println(ans);
	}
	static class Node{
		int idx;
		char ch;
		
		public Node(int idx, char ch) {
			this.idx = idx;
			this.ch = ch;
		}
	}
}
