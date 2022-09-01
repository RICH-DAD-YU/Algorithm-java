import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	
	// 델타 함수
	static int[] dx = { -1, 1,  0, 0 };
	static int[] dy = {  0, 0, -1, 1 };
	
	static int n, m;
	static int num, ans, area;
	
	static int[][] array;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 초기화
		array = new int[n][m];
		visited = new boolean[n][m];
		
		num = 0;
		
		// 데이터 입력 완료
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(visited[i][j] == true || array[i][j] == 0) continue;
				
				BFS(i, j);
				num++; // BFS가 실행되면 num++
				pqueue.offer(area);
			}
		}
		
		System.out.println(num);
		if(pqueue.size() == 0) {
			System.out.println(0);
		}else {
			System.out.println(pqueue.poll());
		}
	}
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		area = 1;
		visited[x][y] = true;
		Node node = new Node(x, y);
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < m && visited[nx][ny] == false && array[nx][ny] == 1 ) {
					visited[nx][ny] = true;
					Node node2 = new Node(nx, ny);
					queue.offer(node2);
					area++;
				}
			}
		}
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}