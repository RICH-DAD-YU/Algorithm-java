package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 접두사찾기_14426 {

	static int N, M, ans;
	static String[] array;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new String[N];
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine();
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			int length = str.length();
			
			for (int j = 0; j < N; j++) {
				if(str.equals(array[j].substring(0, length))) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
