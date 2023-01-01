package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

	static int T; // 테스트 케이스 개수
	static int l; // 체스판의 한 변의 길이
	static int sx, sy, ex, ey; // 나이트의 현재 있는 칸 좌표, 나이트가 이동하려는 좌표
	static int[][] map; // 체스판의 크기

	static int move; // 움직인 횟수
	static boolean[][] visited; // 방문 처리

	// 나이트 이동(시계 방향)
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			l = Integer.parseInt(br.readLine());

			// 배열 초기화
			map = new int[l][l];
			visited = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());

			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			move = 0;

			// 나이트가 현재 있는 칸과 이동하려는 칸이 같으면 바로 move 출력
			if (sx == ex && sy == ey) {
				System.out.println(move);
			} else {
				BFS(sx, sy, move);
			}
		}
	}

	static void BFS(int x, int y, int z) {

		visited[x][y] = true; // 첫 좌표 방문처리
		Node node1 = new Node(x, y, z);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(node1);

		while (!queue.isEmpty()) {

			Node node2 = queue.poll();

			// 나이트 이동(시계 방향) 
			for (int d = 0; d < 8; d++) {
				int nx = node2.x + dx[d];
				int ny = node2.y + dy[d];
				int nz = node2.z + 1; // 1번 움직였으니 1추가
				
				// 목적지에 도달했다면 움직인 거리 출력 후 종료
				if (nx == ex && ny == ey) {
					System.out.println(nz);
					return;
					// 그렇지 않다면(좌표 초과X, 방문하지 않은 곳이라면)
				} else if (0 <= nx && nx < l && 0 <= ny && ny < l && visited[nx][ny] == false) {
					// 새로운 노드 만들어서 queue에 추가
					Node node3 = new Node(nx, ny, nz);
					queue.offer(node3);
					visited[nx][ny] = true; // 새롭게 움직인 좌표 방문 처리
				}
			}
		}
	}

	// 좌표(x, y), z : 움직인 거리
	static class Node {
		int x;
		int y;
		int z;

		public Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
