package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int N, ans;
	static boolean[] check;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	Map<String, Integer> hashMap1 = new LinkedHashMap<String, Integer>();
    	Map<String, Integer> hashMap2 = new LinkedHashMap<String, Integer>();
    	
    	N = Integer.parseInt(br.readLine());
    	
    	check = new boolean[N];
    	
    	// 영식 배열 삽입
    	for (int i = 0; i < N; i++) {
    		
    		String str1 = br.readLine();
			hashMap1.put(str1, i);
		}
    	
    	// 대식 배열 삽입
    	for (int i = 0; i < N; i++) {
    		
    		String str2 = br.readLine();
			hashMap2.put(str2, i);
		}
    	
    	ans = 0;
    	List<String> list = new ArrayList<String>(); 
    	
    	for(String key : hashMap1.keySet()) {
    		list.add(key);
    	}
//    	System.out.println(hashMap1.keySet());
    	for (int i = 0; i < N; i++) {
    		int tmp = hashMap2.get(list.get(i));
    		
    		if(check[tmp] != true) {
    			for (int j = 0; j < tmp; j++) {
					if(check[j] != true) {
						ans++;
						check[j] = true;
					}
				}
    		}
    		check[tmp] = true;
		}
    	System.out.println(ans);
    }
}
