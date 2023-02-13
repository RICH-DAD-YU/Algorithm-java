package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {

	static int N, M;
	
	static int[][] array;
	static boolean[][] visited;
	
	// 상하좌우
	static int[] dx = { -1, 1,  0, 0};
	static int[] dy = {  0, 0, -1, 1};
	
	static int ans;
	static int check;
	static int count;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		// 정답이 나올 때까지 계속 반복
		while(true) {
			
			Queue<Node> queue1 = new LinkedList<Node>();	
			
			// 떨어져있는지 체크
			check = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 바다가 아니고 방문하지 않은 것 중에
					if(array[i][j] != 0 && visited[i][j] == false) {
						check++;
						// check가 1을 넘어가면 떨어진게 있는거임
						if(check > 1) {
							System.out.println(ans);
							return;
						}
						BFS(i, j);
					}
				}
			}
			// 방문 배열 초기화(추후 계속 반복문을 돌리므로)
			visited = new boolean[N][M];
			
			// 주변에 바다가 둘러싸여 있는지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(array[i][j] != 0) {
						int zeroCnt = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							// 범위를 초과하지 않고 주변에 0이 존재한다면
							if(0 <= nx && nx < N && 0 <= ny && ny < M && array[nx][ny] == 0) {
								zeroCnt++;
							}
						}
						// 녹은 정보를 node에 담아 queue1에 넣는다
						Node node = new Node(i, j, array[i][j]-zeroCnt);
						queue1.offer(node);
					}
				}
			}

			// 섬이 하나일 때, 그리고 다 녹아서 큐에 담기는게 없을 때
			if(queue1.size() == 1 || queue1.size() == 0) {
				System.out.println(0);
				return;
			}
			
			// queue1에 담긴 것을 빼서 array 갱신
			while(!queue1.isEmpty()) {
				Node node1 = queue1.poll();
				if(node1.value < 0) {
					array[node1.x][node1.y] = 0;
				}else {
					array[node1.x][node1.y] = node1.value;
				}
			}
			// ans 추가
			ans++;
		}	
	}
	
	static void BFS(int x, int y) {
		
		Queue<Node> queue2 = new LinkedList<Node>();
		
		visited[x][y] = true;
		Node node2 = new Node(x, y);
		queue2.offer(node2);
		
		while(!queue2.isEmpty()) {
			
			Node node3 = queue2.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node3.x + dx[d];
				int ny = node3.y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && visited[nx][ny] == false && array[nx][ny] != 0) {
					visited[nx][ny] = true;
					Node node4 = new Node(nx, ny);
					queue2.offer(node4);
				}
			}
		}
	}
	
	static class Node{
		int x;
		int y;
		int value;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
}
