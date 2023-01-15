package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원_13164 {

	static int N, K; // N : 유치원생의 수, K : 몇 개의 조로 나눌지
	static int[] height; // 신장이 담겨져 있는 배열
	static int[] calculate; // 계산된 배열
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		height = new int[N];
		calculate = new int[N-1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		// 유치원생 수와 조의 수가 같을 시 각 조마다 한 명의 유치원생이 들어가므로 결과값은 0임.
		if(N == K) {
			System.out.println(0);
			return;
		}
		
		// 인접한 수를 계산하여 calculate에 담음(원래라면 정렬을 해야하지만, 문제자체에서 키 순서대로 일렬로 주어짐) 
		for (int i = 0; i < N-1; i++) {
			calculate[i] = height[i+1] - height[i];
		}
		
		// 계산된 값들을 오름차순으로 정렬(최소 비용을 구하기위해)
		Arrays.sort(calculate);
		
		int ans = 0;
		// N-K 개를 합치면 K개의 조가 만들어짐. 그리고 적은 값대로 더해주기
		for (int i = 0; i < N-K; i++) {
			ans += calculate[i];
		}
		System.out.println(ans);
	}
}
