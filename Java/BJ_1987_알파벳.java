package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 알파벳_1987 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int ans;
	static int R, C;
	static char[][] array;

	// 같은 문자인지 판별하기 위해 hashmap 사용
	static HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		array = new char[R][C];

		for (int i = 0; i < R; i++) {
			array[i] = br.readLine().toCharArray();
		}

		ans = 0;
		DFS(0, 0, 1);
		System.out.println(ans);

	}

	static void DFS(int x, int y, int depth) {
		
		hashmap.put(array[x][y], 1);
		ans = Math.max(ans, depth);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 배열의 범위를 넘어가지 않고 hashmap의 key에 문자가 포함되어 있지 않다면
			if (0 <= nx && nx < R && 0 <= ny && ny < C && !hashmap.containsKey(array[nx][ny])) {
				//hashmap에 해당 key를 넣음
				hashmap.put(array[nx][ny], 1);
				// 재귀함수
				DFS(nx, ny, depth + 1);
				// 넘어간다면 해당 key를 제거
				hashmap.remove(array[nx][ny]);
			}
		}
	}
}
