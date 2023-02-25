package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드_10815 {
	
	static int N, M;

	public static void main(String[] args) throws Exception {
		
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hashmap.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(hashmap.containsKey(tmp)) {
				System.out.print(1 + " ");
			}else {
				System.out.print(0 + " ");
			}
		}
	}
}
