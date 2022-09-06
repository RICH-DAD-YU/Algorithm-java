package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	
	static int N;
	static int[] t;
	static int[] p;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	// 배열 초기화
    	t = new int[N];
    	p = new int[N];
    	dp = new int[N+1];
    	
    	Arrays.fill(dp, 0);
    	
    	for (int i = 0; i < N; i++) {
    		
			StringTokenizer st = new StringTokenizer(br.readLine());
    		
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 0; i < N; i++) {
			if(i + t[i] <= N) {
				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
    	}
    	System.out.println(dp[N]);
    }
}
