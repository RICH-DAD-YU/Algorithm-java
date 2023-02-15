package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양_3184 {
	
	static int R, C;
	
	static char[][] array;
	static boolean[][] visited;
	
	// 상, 하, 좌, 우
	static int[] dx = { -1, 1,  0, 0 };
	static int[] dy = {  0, 0, -1, 1 };
	
	static int sheep, wolf, sheep_tmp, wolf_tmp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		array = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			array[i] = br.readLine().toCharArray();;
		}
		
		sheep = 0;
		wolf = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visited[i][j] == false && array[i][j] != '#' ) {
					
					BFS(i, j);
					
					// 양이 많다면 늑대는 쫓아냄
					if(sheep_tmp > wolf_tmp) {
						wolf_tmp = 0;
					// 그렇지 않으면 양이 잡아먹힘
					}else {
						sheep_tmp = 0;
					}
					
					sheep += sheep_tmp;
					wolf += wolf_tmp;
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}
	static void BFS(int x, int y) {
		
		Queue<Node> queue = new LinkedList<Node>();
		
		sheep_tmp = 0;
		wolf_tmp = 0;
		visited[x][y] = true;
		Node node = new Node(x, y);
		queue.offer(node);
		
		if(array[x][y] == 'o') sheep_tmp++;
		if(array[x][y] == 'v') wolf_tmp++;
		
		while(!queue.isEmpty()) {
			Node node1 = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node1.x + dx[d];
				int ny = node1.y + dy[d];
				
				if(0 <= nx && nx < R && 0 <= ny && ny < C && visited[nx][ny] == false && array[nx][ny] != '#') {
					
					if(array[nx][ny] == 'o') {
						sheep_tmp++;
					}else if(array[nx][ny] == 'v') {
						wolf_tmp++;
					}
		
					Node node2 = new Node(nx, ny);
					visited[nx][ny] = true;
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
