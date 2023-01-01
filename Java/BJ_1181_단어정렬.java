package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	
	static int N;
	
    public static void main(String[] args) throws Exception {
    	
    	List<Node> list = new ArrayList<Node>();
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int length = str.length();
			
			if(hashmap.containsKey(str)) continue;
			hashmap.put(str, i);
			
			Node node = new Node(str, length);

			list.add(node);
		}
    	
    	Collections.sort(list, (e1, e2) -> {
    		return e1.word_length != e2.word_length ? e1.word_length - e2.word_length : e1.word.compareTo(e2.word);
    	});
    	
    	int list_size = list.size();
    	
    	for (int i = 0; i < list_size; i++) {
			System.out.println(list.get(i).word);
		}
    }
    
    static class Node{
    	String word;
    	int word_length;
    	
    	public Node(String word, int word_length) {
    		this.word = word;
    		this.word_length = word_length;
    	}
    }
}
