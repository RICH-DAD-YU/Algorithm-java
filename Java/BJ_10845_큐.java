package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_10845 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		StringBuilder sb = new StringBuilder();
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push" :
				tmp = Integer.parseInt(st.nextToken());
				queue.offer(tmp);
				break;
			case "pop" :
				if(queue.size() == 0) {
					sb.append(-1 + "\n");
				}else {
					sb.append(queue.poll() + "\n");
				}
				break;
			case "size" :
				sb.append(queue.size() + "\n");
				break;
			case "empty" :
				if(queue.size() == 0) {
					sb.append(1 + "\n");
				}else {
					sb.append(0 + "\n");
				}
				break;
			case "front" :
				if(queue.size() == 0) {
					sb.append(-1 + "\n");
				}else {
					sb.append(queue.peek() + "\n");
				}
				break;
			case "back" :
				if(queue.size() == 0) {
					sb.append(-1 + "\n");
				}else {
					sb.append(tmp + "\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
