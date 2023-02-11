package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935 {

	static char[] array;
	static char[] explode;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		array = br.readLine().toCharArray();
		int arrLength = array.length;
		
		explode = br.readLine().toCharArray();
		int exLength = explode.length;
		
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		
		for (int i = 0; i < arrLength; i++) {
			stack1.push(array[i]);
			
			int check = 0;
			if(array[i] == explode[exLength-1] && stack1.size() >= exLength) {
				for (int j = exLength-1; j >= 0; j--) {
					if(stack1.peek() == explode[j]) {
						stack2.push(stack1.pop());
						check++;
					}else {
						while(check > 0) {
							stack1.push(stack2.pop());
							check--;
						}
					}
				}
			}
		}
		int Ssize = stack1.size();
		char[] ans = new char[Ssize];
		
		if(Ssize == 0) {
			System.out.println("FRULA");
			return;
		}
		
		for (int i = Ssize-1; i >= 0; i--) {
			ans[i] = stack1.pop();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Ssize; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb.toString());
	}
}





