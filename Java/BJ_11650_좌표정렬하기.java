package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬하기_11650 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Node> list = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			Node node = new Node(u, v);
			list.add(node);
		}
		
		Collections.sort(list, (e1, e2) -> {
			return e1.x == e2.x ? e1.y - e2.y : e1.x - e2.x;
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}

	}
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
