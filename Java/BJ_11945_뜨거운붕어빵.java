package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뜨거운붕어빵_11945 {

	static int N, M;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				sb.append(str.charAt(j));
			}
			System.out.println(sb.reverse().toString());
		}
	}
}
