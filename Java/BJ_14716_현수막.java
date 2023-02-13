package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현수막_14716 {

	static int M, N;
	static int[][] array;
	static boolean[][] visited;
	
	// 8방 탐색(좌, 좌상, 상, 우상, 우, 우하, 하, 좌하)
	static int[] dx = {  0, -1, -1, -1, 0, 1, 1,  1};
	static int[] dy = { -1, -1,  0,  1, 1, 1, 0, -1};
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		array = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 방문하지 않았고 배열값이 1인 것만 확인
				if(visited[i][j] == false && array[i][j] == 1) {
					ans++;
					BFS(i, j);
				}
			}
		}	
		System.out.println(ans);
	}

	static void BFS(int x, int y) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		visited[x][y] = true;
		Node node = new Node(x, y);
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			
			Node node1 = queue.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = node1.x + dx[d];
				int ny = node1.y + dy[d];
				// 배열의 범위를 벗어나지 않았고 방문하지 않았고 배열의 값이 1이면 queue에 삽입
				if(0 <= nx && nx < M && 0 <= ny && ny < N && visited[nx][ny] == false && array[nx][ny] == 1) {
					visited[nx][ny] = true;
					Node node2 = new Node(nx, ny);
					queue.offer(node2);
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
