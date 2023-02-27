package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 비슷한단어_2179 {
	
	static int N;
	
	static String[] array;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		array = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			array[i] = str;
		}
		
		List<Node> list = new ArrayList<Node>();
		
		for (int i = 0; i < N; i++) {
			int maxLength = 0;
			String str1 = array[i];
			int str1Length = str1.length();
			
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				int same = 0; // 접두사의 길이
				String str2 = array[j];
				int str2Length = str2.length();
				
				int tmpLength = Math.min(str1Length, str2Length);
				
				for(int k = 0; k < tmpLength; k++) {
					if(str1.charAt(k) == str2.charAt(k)) {
						same++;
					}else {
						break;
					}
				}
				maxLength = Math.max(maxLength, same);
			}
			Node node = new Node(str1, i, maxLength);
			list.add(node);
		}
		
		// 접두사 길이 제일 긴거 기준으로 정렬 - 빠른 순서대로 정렬
		Collections.sort(list, (e1, e2) -> {
			return e1.maxLength != e2.maxLength ? e2.maxLength - e1.maxLength : e1.num - e2.num;
		});
		
		// 맨 처음 문자열과 겹치는 문자열 탐색 후 제일 긴 문자열을 출력한다.
		String ans1Str = list.get(0).str;
		int ans1Length = list.get(0).maxLength;
	
		List<Node> list2 = new ArrayList<Node>();
		
		for (int i = 1; i < N; i++) {
			int tmpLength = Math.min(ans1Length, list.get(i).maxLength);
			String tmpStr = list.get(i).str;
			int same = 0;
			
			for(int j = 0; j < tmpLength; j++) {
				if(ans1Str.charAt(j) == tmpStr.charAt(j)) {
					same++;
				}else {
					break;
				}
			}
			Node node2 = new Node(tmpStr, i, same);
			list2.add(node2);
		}
		
		Collections.sort(list2, (e1, e2) -> {
			return e1.maxLength != e2.maxLength ? e2.maxLength - e1.maxLength : e1.num - e2.num;
		});
		
		System.out.println(ans1Str);
		System.out.println(list2.get(0).str);
	}
	
	static class Node{
		int num;
		int maxLength;
		String str;
		
		public Node(String str, int num, int maxLength) {
			this.str = str;
			this.num = num;
			this.maxLength = maxLength;
		}
	}
}
