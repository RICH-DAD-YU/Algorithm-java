package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 듣보잡_1764 {
	
	static int N, M; // N : 듣도 못한 사람, M : 보도 못한 사
	
	public static void main(String[] args) throws Exception {
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		PriorityQueue<String> pqueue = new PriorityQueue<String>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			hashmap.put(str, i);
		}
		
		int count = 0;
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if(hashmap.containsKey(str)) {
				pqueue.offer(str);
				count++;
			}
		}
		
		System.out.println(count);
		while(!pqueue.isEmpty()) {
			System.out.println(pqueue.poll());
		}
	}
}
