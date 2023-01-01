package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, sum, ans;
	
	// 델타 함수(상, 하, 좌, 우)
	static int[] dx = { -1, 1,  0, 0 };
	static int[] dy = {  0, 0, -1, 1 };
	
	static char[][] array;
	static boolean[][] visited;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	array = new char[N+1][M+1];
    	visited = new boolean[N+1][M+1];
    	
    	for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			array[x][y] = 'R'; //음식물이다 도망치자 Run
		}
    	
    	sum = 0;
    	ans = 0;
    	
    	for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(array[i][j] == 'R') {
					BFS(i, j);
					ans = Math.max(sum, ans);
				}
			}
		}
    	System.out.println(ans);
    }
    static void BFS(int x, int y) {
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	visited[x][y] = true;
    	sum = 1;
    	
    	Node node = new Node(x, y);
    	queue.offer(node);
    	
    	while(!queue.isEmpty()) {
    		
    		Node tmp = queue.poll();
    		
    		for (int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(1 <= nx && nx <= N && 1 <= ny && ny <= M && visited[nx][ny] == false && array[nx][ny] == 'R') {
					visited[nx][ny] = true;
					Node tmp2 = new Node(nx, ny);
					queue.offer(tmp2);
					sum++;
				}
			}
    		
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
