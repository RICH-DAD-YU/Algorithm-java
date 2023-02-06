package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pqueue.offer(num);
		}
		
		int ans = 0;
		
		while(!pqueue.isEmpty()) {
			
			if(pqueue.size() == 1) break;
			
			int tmp1 = pqueue.poll();
			int tmp2 = pqueue.poll();
			int tmp3 = tmp1 + tmp2;
			
			ans += tmp3;
			
			pqueue.offer(tmp3);	
		}
		System.out.println(ans);
	}
}
