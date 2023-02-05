package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어순서뒤집기_12605 {

	static int T;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			Stack<String> stack = new Stack<String>();
			StringBuilder sb = new StringBuilder();
			
			String str = br.readLine();
			
			String[] array = str.split(" ");
			
			for (int i = 0; i < array.length; i++) {
				stack.push(array[i]);
			}
			
			sb.append("Case #" + t +": ");
			while(!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
			}
			System.out.println(sb.toString());
								
		}
	}
}
