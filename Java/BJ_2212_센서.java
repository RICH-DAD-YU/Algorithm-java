package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서_2212 {
	
	static int N, K;
	static int[] array;
	static int[] subarray;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		if(K >= N) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(array);
		
		subarray = new int[N-1];
		
		for (int i = 0; i < N-1; i++) {
			subarray[i] = array[i+1] - array[i];
		}
		
		Arrays.sort(subarray);
		
		int ans = 0;
		for (int i = 0; i < N-K; i++) {
			ans += subarray[i];
		}

		System.out.println(ans);
	}

}
