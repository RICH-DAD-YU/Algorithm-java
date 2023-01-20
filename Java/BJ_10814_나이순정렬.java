package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Node> list = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			Node node = new Node(age, name, i);
			
			list.add(node);
		}
		
		Collections.sort(list, (e1, e2) -> {
			return e1.age == e2.age ? e1.num - e2.num : e1.age - e2.age;
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}

	}
	
	static class Node{
		int age;
		String name;
		int num;
		
		public Node(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;
		}
	}
}
