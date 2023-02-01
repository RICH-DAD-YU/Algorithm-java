package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물_14235 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int present = Integer.parseInt(st.nextToken()); 
			
			if(present == 0) {
				if(pqueue.size() == 0) {
					System.out.println(-1);
				}else {
					System.out.println(pqueue.poll());
				}
			}else {
				for (int j = 0; j < present; j++) {
					pqueue.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
}