package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {

	// 델타 함수(상, 하, 좌, 우)
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int R, C, distance; // R : 가로, C : 세로, distance : 거리
	static char[][] map; // 지도
	static boolean[][] visited; // 방문 여부 확인
	
	static int ans; // 정답 변수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 변수 초기화
		map = new char[R][C];
		distance = 0;
		ans = 0;
		

		// map에 육지 바다 정보 입력 완료
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 좌표의 값이 L이라면 BFS 실행
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[R][C]; // 방문 여부는 각 원소마다 초기화시켜줘야 함
					visited[i][j] = true; // 시작 방문 체크
					BFS(i, j, distance); 
				}
			}
		}
		System.out.println(ans);
	}

	static void BFS(int x, int y, int z) {

		Queue<Node> queue = new LinkedList<Node>();
		Node node1 = new Node(x, y, z);		
		queue.offer(node1);
		// 이동거리 저장할 변수
		int tmp = 0;
		while(!queue.isEmpty()) {
			Node node2 = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node2.x + dx[d];
				int ny = node2.y + dy[d];
				tmp = node2.z;
				if(0 <= nx && nx < R && 0 <= ny && ny < C && map[nx][ny] == 'L' && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					tmp++;
					Node node3 = new Node(nx, ny, tmp);
					queue.offer(node3);
					// 이동 전과 비교하여 더 큰 값 정답으로 저장
					ans = Math.max(ans, tmp);
				}
			}
		}
	}

	// 좌표를 이용하여 BFS 실행
	static class Node {
		int x;
		int y;
		int z; // 거리와 함께 전달

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
