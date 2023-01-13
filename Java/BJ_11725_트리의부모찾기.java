package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {

	static int N;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		
		List<Integer>[] connection = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			connection[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			connection[u].add(v);
			connection[v].add(u);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int child : connection[node]) {
				// 0이 아니라는 말은 부모 노드가 정해졌다는 말이므로 continue
				if(parent[child] != 0) continue;
				parent[child] = node;
				queue.offer(child);
			}
		}
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(parent[i]);
		}
		
	}
}
