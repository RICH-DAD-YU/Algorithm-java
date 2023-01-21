package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 전화번호목록_5052 {

	static int T, N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int ans = 0;
			
			N = Integer.parseInt(br.readLine());
			List<Node> list = new ArrayList<Node>();
		
			for (int i = 0; i < N; i++) {
						
				String tell = br.readLine();
				
				int tellLength = tell.length();
				
				Node node = new Node(tell, tellLength);
				
				list.add(node);
			}
			// 문자열 오름차순 정렬(뒷 단어 접두사와 비교)
			Collections.sort(list, (e1, e2) -> e1.tell.compareTo(e2.tell));
			
			for (int i = 0; i < N-1; i++) {
				// 하나 큰 인덱스의 접두어가 같으면 ans++
				if(list.get(i+1).tell.startsWith(list.get(i).tell)) {
					ans++;
					break;
				}
			}
		
			if(ans >= 1) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}

	static class Node{
		String tell;
		int tellLength;
		
		public Node(String tell, int tellLength) {
			this.tell = tell;
			this.tellLength = tellLength;
		}
	}
}
