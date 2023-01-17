package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 이차원배열과연산_17140 {

	static int r, c, k;
	static int[][] array;

	static int row, col;
	static int ans;

	static int[] count;
	static List<Node> list = new ArrayList<Node>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		array = new int[101][101]; // 행과 열의 크기가 100보다 커질 수는 없음
		// row와 col은 추후에 계속 업데이트
		row = 3;
		col = 3;
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		if(array[r-1][c-1] == k) {
			System.out.println(ans);
			return;
		}
		
		while(true) {
			// ans 정답에 100보다 커지면 -1 출력 후 return
			if(ans > 100) {
				System.out.println(-1);
				return;
			}
			
			if(row >= col) {
				for (int i = 0; i < 100; i++) {
					count = new int[101]; // 탐색되는 수의 빈도를 체크하기 위해 만듬
					for (int j = 0; j < 100; j++) {
						if(array[i][j] != 0) {
							count[array[i][j]]++;
							array[i][j] = 0; // 현재 있는 값을 0으로 만들고 추후 정렬된 값 삽입
						}
					}
	
					// 빈도 체크한 배열을 탐색하여 node로 생성(추후 정렬에 활용)
					for (int j = 1; j < 101; j++) {
						if(count[j] != 0) {
							Node node = new Node(j, count[j]);
							list.add(node);
						}
					}
					// 담긴 node를 기준으로 정렬
					// 1. 수의 등장 횟수가 커지는 순으로
					// 2. 1이 여러 개면 수가 커지는 순으로 정렬
					Collections.sort(list, (e1, e2) -> {
						return e1.y != e2.y ? e1.y - e2.y : e1.x - e2.x;
					});
					
					// node 사이즈만큼 array 배열에 값을 삽입
					int nodeSize = list.size();
					if(nodeSize*2 > 100) {
						nodeSize = 50;
					}
					
					int index = 0;
					for (int j = 0; j < nodeSize; j++) {
						int a = list.get(j).x;
						int b = list.get(j).y;
						
						array[i][index] = a;
						array[i][1+index] = b;
						
						index += 2;
					}
					col = Math.max(col, nodeSize*2);
					list.clear(); // 다시 사용되기 위한 list 초기화
				}
				
				if(array[r-1][c-1] == k) {
					ans++;
					System.out.println(ans);
					return;
				}else {
					ans++;
				}
			}else { // row < col
				for (int i = 0; i < 100; i++) {
					count = new int[101]; // 탐색되는 수의 빈도를 체크하기 위해 만듬
					for (int j = 0; j < 100; j++) {
						if(array[j][i] != 0) {
							count[array[j][i]]++;
							array[j][i] = 0;
						}
					}
					// 빈도 체크한 배열을 탐색하여 node로 생성(추후 정렬에 활용)
					for (int j = 1; j < 101; j++) {
						if(count[j] != 0) {
							Node node = new Node(j, count[j]);
							list.add(node);
						}
					}
					// 담긴 node를 기준으로 정렬
					Collections.sort(list, (e1, e2) -> {
						return e1.y != e2.y ? e1.y - e2.y : e1.x - e2.x;
					});
					
					// node 사이즈만큼 array 배열에 값을 삽입
					int nodeSize = list.size();
					if(nodeSize*2 > 100) {
						nodeSize = 50;
					}
//					System.out.println("nodeSize : " + nodeSize );
					int index = 0;
					for (int j = 0; j < nodeSize; j++) {
						int a = list.get(j).x;
						int b = list.get(j).y;
						
						array[index][i] = a;
						array[1+index][i] = b;
						
						index += 2;
					}
					row = Math.max(row, nodeSize*2);
					list.clear(); // 다시 사용되기 위한 list 초기화
				}
				
				if(array[r-1][c-1] == k) {
					ans++;
					System.out.println(ans);
					return;
				}else {
					ans++;
				}
			}
		}
	}

	// 노드 만들기
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}