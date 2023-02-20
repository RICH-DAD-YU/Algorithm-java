package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 뒤집기_1439 {

	static String str;
	static char[] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 입력
		str = br.readLine();

		// 문자열 길이
		int strLength = str.length();
		
		// 각 배열 만들기
		array = str.toCharArray();
		visited = new boolean[strLength];
		
		// 0이 끊기는 횟수 구하기
		int zero = 0;
		for (int i = 0; i < strLength; i++) {
			if(array[i] == '0' && visited[i] == false) {
				zero++;
				for (int j = i+1; j < strLength; j++) {
					// 0이 끊긴다
					if(array[j] == '1') {
						break;
					}else {
						visited[j] = true;
					}
				}
			}
		}
		
		// 1이 끊기는 횟수 구하기
		int one = 0;
		for (int i = 0; i < strLength; i++) {
			if(array[i] == '1' && visited[i] == false) {
				one++;
				for (int j = i+1; j < strLength; j++) {
					// 1이 끊긴다
					if(array[j] == '0') {
						break;
					}else {
						visited[j] = true;
					}
				}
			}
		}
		// 둘 중에 최솟값 구하기
		System.out.println(Math.min(zero, one));
	}

}
