package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀_3190 {

	static int N, K, L; // N : 보드의 크기, K : 사과의 개수, L : 뱀의 방향 전환 횟수
	static int[][] map; // 보드
	
	// 델타 함수를 통한 상, 우, 하, 좌
	static int[] dx = {-1, 0, 1,  0};
	static int[] dy = { 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; // 0인덱스는 제외
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1; // 사과가 있는 위치는 1로 표시
			
		}
		
		L = Integer.parseInt(br.readLine());
		
		// time과 방향을 설정하기 위한 queue
		Queue<Node> queue = new LinkedList<Node>();
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			
			Node node = new Node(time, direction);
			
			queue.offer(node);
		}
		
		// 처음 위치, 시간, 이동 방향
		int ans = 0;
		int dir = 1; // 오른쪽 방향
		int mx = dx[dir]; // 상, "우", 하, 좌
		int my = dy[dir]; // 상, "우", 하, 좌
		
		// 움직이고 난 후 위치
		int nx = 1;
		int ny = 1; 
		
		// 뱀의 위치를 넣을 queue
		Queue<Location> snake = new LinkedList<Location>();
		
		Location loc = new Location(nx, ny); // 처음 위치
		snake.offer(loc);
		
		while(true) {

			// 움직이고 난 후의 좌표(nx, ny)
			nx += mx;
			ny += my;
			ans++; // 움직였으므로 ans++(시간)
			
			// 위치 정보가 담긴 객체를 만든다
			Location location = new Location(nx, ny);
			
			// snake 큐에 담긴 좌표를 확인하며 몸통과 부딪히는지 확인
			int size = snake.size();
			for (int i = 0; i < size; i++) {
				Location loc1 = snake.poll();
				int x = loc1.x;
				int y = loc1.y;
				// 부딪히면 정답 출력 후 return
				if(nx == x && ny == y) {
					System.out.println(ans);
					return;
				// 부딪히지 않으면 다시 queue에 넣는다
				}else {
					snake.offer(loc1);
				}
			}
			
			// 조건에 부합하지는 확인
			// 벽을 만났을 때
			if(nx < 1 || nx > N || ny < 1 || ny > N) {
				System.out.println(ans);
				return;
			// 사과를 만났을 때
			}else if(map[nx][ny] == 1) {
				snake.offer(location); // 사과가 있던 좌표를 snake 큐에 삽입
				map[nx][ny] = 0; // 사과 자리를 0으로 만든다
			// 조건에 부합하는게 없을 때
			}else {
				snake.poll(); // 제일 처음에 넣은 좌표 poll
				snake.offer(location); // 새로운 좌표 삽입
			}
			
			// queue에 들어있는 좌표를 토대로 방향 설정하기
			if(queue.size() != 0) {
				// 방향 설정하기
				Node node1 = queue.peek();
				
				int time = node1.time;
				char direction = node1.direction;

				// 시간이 동일하다면 이동 방향 변환
				if(ans == time) {
					switch(direction) {
					case 'L' :
						dir -= 1;
						if(dir < 0) dir = 3;
		
						mx = dx[dir];
						my = dy[dir];
						break;
					case 'D' :
						dir += 1;
						if(dir > 3) dir = 0;
						
						mx = dx[dir];
						my = dy[dir];
						break;
					}
					// 방향을 바꾸었으므로 큐에서 제거
					queue.poll();
				}
			}
		}
	}
	static class Node{
		int time;
		char direction;
		
		public Node(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}
	
	static class Location{
		int x;
		int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
