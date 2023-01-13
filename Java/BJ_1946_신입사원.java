package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 서류 심사 1등 기분으로 면접 시험 성적 순위 업데이트하면서 사람 수 세기
public class 신입사원_1946 {

	static int T, N;
	static int u, v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			List<Node> list = new ArrayList<Node>();
			
			N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());

				Node node = new Node(u, v);
				list.add(node);
			}
			
			// 서류심사 성적 기준으로 정렬
			Collections.sort(list, (e1, e2) -> {
				return e1.x - e2.x;
			});
			
			// 서류심사 1등
			int ans = 1;
			// 서류심사 1등의 면접 성적
			int grade = list.get(0).y;
			
			// 면접 성적 높으면 grade 업데이트하고 ans++
			for (int i = 1; i < N; i++) {

				if(list.get(i).y < grade) {
					ans++;
					grade = list.get(i).y;
				}
			}
			System.out.println(ans);
		}
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}