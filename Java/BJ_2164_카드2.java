package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// queue에 값 삽입
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		// queue가 1이 아닌동안은 a, b 반복
		while(queue.size() != 1) {
			// a. queue에 들어있는 값 꺼내기
			queue.poll();
			// b. 두 번째로 꺼낸 것은 다시 queue에 넣기
			int tmp = queue.poll();
			queue.offer(tmp);
		}
		
		System.out.println(queue.poll());
	}
}
