package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// set 사용해서 중복제거 하는 것이 포인트
public class 서로다른부분문자열의개수_11478 {
		
	static char[] input;
	
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int strLength = str.length();
		
		for (int i = 0; i < strLength; i++) {
			for (int j = i; j < strLength; j++) {
				// 문자열 나눠서 set에 저장
				String tmp = str.substring(i, j+1);
				set.add(tmp);
			}
		}
		// set의 사이즈 출력
		System.out.println(set.size());
			
	}
}
