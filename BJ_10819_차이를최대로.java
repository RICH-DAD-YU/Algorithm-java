package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {

	static int N, ans;
	static int[] input, numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		
		permutation(0);
		
		System.out.println(ans);

	}
	
	static void permutation(int cnt) {
		int tmp = 0;
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				if(i == N-1) break;
				tmp += (Math.abs(numbers[i]-numbers[i+1]));
			}
			ans = Math.max(ans, tmp);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i] == true) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
