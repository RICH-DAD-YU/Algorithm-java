package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {

	static int N;
	static int[][] stats;
	static int[] overall;
	static int[] link;
	static boolean[] visited;

	static int ans;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		stats = new int[N][N];
		overall = new int[N];
		visited = new boolean[N];
		link = new int[N / 2];
		ans = Integer.MAX_VALUE;

		// 선수들의 능력치 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			overall[i] = i;
			for (int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 조합 사용
		combination(0, 0);
		System.out.println(ans);
	}

	static void combination(int cnt, int index) {
		int tmp1 = 0;
		int tmp2 = 0;
		
		/** 
		 * 방문 처리가 false인 것은 start로 추가
		 * 일반적인 배열로 만들지 않은 이유는 N개를 돌면서 false인 것을 바로 추가시켜줘야 하기 떄문임
		 * 배열로 만들었다면 인덱스 설정하는 부분이 애매함
		 */
		List<Integer> start = new ArrayList<Integer>();

		// link팀이 다 뽑힌 경우라면
		if (cnt == N / 2) {
			// 같은 인덱스를 제외하고는 모두 더해준다.
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == j) continue;
					tmp1 += stats[link[i]][link[j]];
				}
			}

			// 방문 처리가 false인 경우 start팀에 추가
			for (int i = 0; i < N; i++) {
				if (visited[i] == false) {
					start.add(i);
				}
			}

			// start팀의 능력치를 모두 더해준다.
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					if(i == j) continue;
					tmp2 += stats[start.get(i)][start.get(j)];
				}
			}
			
			// link 팀과 start팀의 차이를 절댓값으로 표현
			int min = Math.abs(tmp1 - tmp2);
			// 더 작은 값을 ans로 저장
			ans = Math.min(ans, min);
			return;
		}

		for (int i = index; i < N; i++) {
			link[cnt] = overall[i];
			// 추후 start팀을 구분하기 위해 link팀은 true로 표현
			visited[i] = true;
			// 하나 더 뽑히므로 cnt + 1, 다음 인덱스를 위한 i+1
			combination(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
}
