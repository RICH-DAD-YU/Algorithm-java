package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int N,ans;
	
    public static void main(String[] args) throws Exception {
    	
    	List<Node> list = new ArrayList<Node>();
    	List<String> list2 = new ArrayList<String>();
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int strLength = str.length();
			Node node = new Node(str, strLength);
			
			list.add(node);
		}
    	
    	Collections.sort(list, (e1, e2) -> {
    		return e1.y != e2.y ? e1.y - e2.y : e1.x.compareTo(e2.x);
    	});
        	
    	for (int i = 0; i < N; i++) {
			String tmp = list.get(i).x;
			int tmpLength = list.get(i).y;
			
			if(i == N-1) break;
			
			for (int j = i+1; j < N; j++) {
				// 정렬된 배열에서 문자열의 길이가 같을 때.
				if(tmpLength == list.get(j).y) {
//					System.out.println("길이 같을 때 : " + list.get(j).x);
					// 기준의 문자열과 그 다음 인덱스의 문자열이 동일하다면
					if(tmp.equals(list.get(j).x)) {
						list2.add(tmp);
						break;
					}
				// 정렬된 배열에서 문자열의 길이가 다를 때
				}else if(tmpLength != list.get(j).y) {
					if(list.get(j).x.substring(0, tmpLength).equals(tmp)) {
//					if(list.get(j).x.startsWith(tmp)) {
//						System.out.println("substring :" + list.get(j).x.substring(0, tmpLength));
						list2.add(tmp);
						break;
					}
				}
			}	
		}
    	System.out.println(N-list2.size());
    }
    
    static class Node{
    	String x;
    	int y;
    	public Node(String x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
