package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pqueue.size() == 0) {
					System.out.println(0);
				}else {
					System.out.println(pqueue.poll());
				}
			}else {
				pqueue.offer(num);
			}
		}
	}
}
