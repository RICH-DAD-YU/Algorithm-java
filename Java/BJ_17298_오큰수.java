package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {

	static int N;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
				array[stack.pop()] = array[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			array[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(array[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
}
