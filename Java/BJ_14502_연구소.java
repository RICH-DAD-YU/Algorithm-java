package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 아이디어 : 0인 것들 중에서 조합으로 3개씩 꺼내어 1로 만듦. 그리고 동시에 bfs 실행
public class 연구소_14502 {
	
	static int N, M;
	static int[][] array;
	static boolean[][] visited;
	
	// 델타 함수(상, 하, 좌, 우)
	static int[] dx = { -1, 1,  0, 0 };
	static int[] dy = {  0, 0, -1, 1 };

	static int zero_cnt;
	static int tmp, ans;
	
	static List<Node> list = new ArrayList<Node>();
	static List<Node> numbers = new ArrayList<Node>();
	static List<Node> bfsValue = new ArrayList<Node>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				array[i][j] = value;
				if(value == 0) {
					zero_cnt++;
					Node node = new Node(i, j);
					list.add(node);
				}
			}
		}
		ans = 0;
		combination(0, 0);
		System.out.println(ans);

	}
	
	static void combination(int start, int count) {
		tmp = 0;
		visited = new boolean[N][M];
		if(count == 3) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(array[i][j] == 2) {
						BFS(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(array[i][j] == 0) {
						tmp++;
					}
				}
			}
			ans = Math.max(tmp, ans);

			// bfs를 실행하면서 변환된 것들을 원래의 값으로 되돌림
			for (int i = 0; i < bfsValue.size(); i++) {
				array[bfsValue.get(i).x][bfsValue.get(i).y] = 0;
			}
			bfsValue.clear();
			return;
		}
		
		for (int i = start; i < zero_cnt; i++) {
			
			array[list.get(i).x][list.get(i).y] = 1;
			combination(i+1, count+1);
			array[list.get(i).x][list.get(i).y] = 0;
		}
	}
	
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		visited[x][y] = true;
		
		Node node4 = new Node(x, y);
		queue.offer(node4);
		
		while(!queue.isEmpty()) {
			
			Node node1 = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node1.x + dx[d];
				int ny = node1.y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && visited[nx][ny] == false && array[nx][ny] == 0) {
					array[nx][ny] = 2;
					visited[nx][ny] = true;
					Node node2 = new Node(nx, ny);
					bfsValue.add(node2);
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
