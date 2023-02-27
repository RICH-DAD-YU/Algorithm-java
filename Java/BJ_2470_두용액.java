package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {

	static int N;
	static int ans;

	static int[] array;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		array = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(array);
		
		int gap = Integer.MAX_VALUE;
		int start = 0;
		int end = array.length - 1;
		int ans1 = 0;
		int ans2 = 0;
		
		while(start < end) {
			int sum = array[start] + array[end];
			int abs = Math.abs(sum);
			
			if(abs < gap) {
				gap = abs;
				ans1 = array[start];
				ans2 = array[end];
			}
			
			if(sum > 0) {
				end--;
			}else {
				start++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}
