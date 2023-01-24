package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 점수대로 내림차순 정렬 후, 그 점수의 날짜 인덱스부터 1인덱스까지 탐색하며 값이 0일 때 값을 대입
public class 과제_13904 {
	
	static int N;
	
	static int[] array;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Node> list = new ArrayList<Node>();
		
		// 배열 크기를 정하기 위해 남은 일자가 최고인 날을 구해야 함.
		int maxday = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			Node node = new Node(day, score);
			
			list.add(node);
			
			maxday = Math.max(maxday, day);
		}
		
		// 0인덱스는 제외하고 1부터 시작할거라서 +1을 해줌
		array = new int[maxday+1];
		
		// 점수별 내림차순으로 정렬
		Collections.sort(list, (e1, e2) -> {
			return e2.score - e1.score;
		});
		
		
		for (int i = 0; i < N; i++) {
			int day = list.get(i).day;
			int score = list.get(i).score;
			
			// 남은 날짜 -> 1인덱스까지 탐색하며 0일 경우 값을 대입하고 for문을 끝냄
			for (int j = day; j >= 1; j--) {
				if(array[j] == 0) {
					array[j] = score;
					break;
				}
			}
		}
		int ans = 0;
		// 대입되어진 점수를 더함
		for (int i = 1; i <= maxday; i++) {
			ans += array[i];
		}
		
		System.out.println(ans);

	}
	
	static class Node{
		int day;
		int score;
		
		public Node(int day, int score) {
			this.day = day;
			this.score = score;
		}
	}
}
