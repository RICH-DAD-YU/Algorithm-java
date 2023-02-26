package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 회문_17609 {

	static int N;

	static char[] array;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {

			String str = br.readLine();
			
			sb.append(checkPalindrome(str, 0, 0, str.length()-1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int checkPalindrome(String str, int result, int front, int back) {
		
		if(result == 2) {
			return 2;
		}
		
		while(front <= back) {
			if(str.charAt(front) == str.charAt(back)) {
				front++;
				back--;
			}else {
				// front+1인 거랑 back-1이랑 비교해서 더 작은 값을 result로
				result = Math.min(checkPalindrome(str, result+1, front+1, back), checkPalindrome(str, result+1, front, back-1));
				break;
			}
		}
		return result;
	}
}