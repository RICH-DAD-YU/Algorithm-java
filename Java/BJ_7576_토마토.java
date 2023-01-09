package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

	static int M, N; // M : column, N : row
	
	static int[][] map; // 토마토 창고
	
	// 4방 탐색을 위한 델타 배열(상, 하, 좌, 우)
	static int[] dx = { -1, 1,  0, 0 };
	static int[] dy = {  0, 0, -1, 1 };
	
	static int time; // 모두 익는 날짜 변수 저장
	
	static List<Node> list = new ArrayList<Node>(); // map을 탐색하여 1인 것을 집어 넣는다.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // column 입력
		N = Integer.parseInt(st.nextToken()); // row 입력
		
		// map 초기화
		map = new int[N][M];

		// 데이터 입력 받기 완료!
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// map의 값이 1이라면 list에 추가
				if(map[i][j] == 1) {
					list.add(new Node(i, j));
				}
			}
		}
		// BFS를 통해 날짜들 저장
		BFS();
		
		// time 초기화
		time = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 0이 존재한다면 -1을 출력하고 바로 return
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				// 그렇지 않다면 최대값을 비교하며 최대값 time에 저장
				else {
					time = Math.max(time, map[i][j]);
				}
			}
		}
		// 맨 처음 시작값이 1이므로 날짜 계산을 위해 1을 빼줌.
		System.out.println(time - 1);		
	}

	static void BFS() {
		Queue<Node> queue = new LinkedList<Node>();
		// map 배열에서 1인 좌표값 저장
		int size = list.size();
		// queue에 list 뽑아서 저장
		for (int i = 0; i < size; i++) {
			queue.offer(list.get(i));
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
					map[nx][ny] = map[node.x][node.y] + 1;
					queue.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	// 좌표 계산을 위한 Node 클래스 생성
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
