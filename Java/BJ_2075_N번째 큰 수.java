import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] array;
	
	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		
		// 데이터 입력 완료
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pqueue.offer(array[i][j]);
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			pqueue.poll();
		}
		
		System.out.println(pqueue.poll());
	}
}