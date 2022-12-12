package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겉넓이구하기_16931 {

	static int N, M; // 종이의 크기
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 종이 크기에 따른 map의 크기 설정
		map = new int[N][M];
		
		// map 배열에 각각의 정보 담기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/**
		 * 변수 초기화
		 * (up = down), (front = back), (left = right) -> 추후에 2를 곱해준다.
		 * 		front
		 * left			right
		 * 		back
		 * 처럼 만들어서 문제 풀이		 
		 */
		
		int ans = 0;
		int up = 0;
		int front = 0;
		int left = 0;
		
		// 윗면
		up = N * M;
		
		// 앞면
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if(i == 0) { // 맨 처음 보이는 면이니까 무조건 더해준다.
					front += map[i][j];
				}else {
					// 뒤에 있는 도형이 더 크다면 차이만큼 더해준다.
					if(map[i-1][j] < map[i][j]) {
						front += (map[i][j] - map[i-1][j]);
					}
				}	
			}
		}
		
		// 왼쪽
		// 앞면에서 구하는 알고리즘과 똑같다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(j == 0) {
					left += map[i][j];
				}else {
					if(map[i][j-1] < map[i][j]) {
						left += (map[i][j] - map[i][j-1]);
					}
				}
			}
		}
		
		// 최종답(down, back, right의 값까지 계산)
		ans = 2 * (up + front + left);
		
		System.out.println(ans);
	}
}
