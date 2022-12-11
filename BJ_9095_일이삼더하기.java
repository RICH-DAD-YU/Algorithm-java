package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일이삼더하기_9095 {

	static int T; // 테스트 케이스 개수
	static int n;
	static int[] dp = new int[11];
	
	public static void main(String[] args) throws Exception {
		
		dp[1] = 1;
		dp[2] = 2;
		/**
		 * 1+1
		 * 2
		 */
		dp[3] = 4;
		/**
		 * 1+1+1
		 * 1+2
		 * 2+1
		 * 3
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
