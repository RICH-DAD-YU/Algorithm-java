package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기_17608 {

	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int num = stack.pop();
		int ans = 1;
		
		while(!stack.isEmpty()) {
			int tmp = stack.pop(); 
			if(tmp > num) {
				num = tmp;
				ans++;
			}
		}
		
		System.out.println(ans);

	}
}
