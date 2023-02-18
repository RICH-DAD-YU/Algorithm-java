package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS_9251 {
	
	static int[][] array;
	
	static char[] tmp1; // 첫 번째 문자열 저장
	static char[] tmp2; // 두 번째 문자열 저장
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 문자열
		String str1 = br.readLine();
		int str1Length = str1.length();
		tmp1 = new char[str1Length+1];
		for (int i = 0; i < str1Length; i++) {
			tmp1[i+1] = str1.charAt(i);
		}
		
		
		// 두 번째 문자열
		String str2 = br.readLine();
		int str2Length = str2.length();
		tmp2 = new char[str2Length+1];
		for (int i = 0; i < str2Length; i++) {
			tmp2[i+1] = str2.charAt(i);
		}
		
		array = new int[str1Length+1][str2Length+1];
		
		// LCS
		for (int i = 0; i < str1Length+1; i++) {
			for (int j = 0; j < str2Length+1; j++) {
				// 일단 앞마진은 0으로 값 지정
				if(i == 0 || j == 0) {
					array[i][j] = 0;
				// 값이 다르면 위 인덱스, 좌 인덱스 중 최댓값을 넣음
				}else if(tmp1[i] != tmp2[j]) {
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
				// 값이 같다면 좌상 인덱스에서+1
				}else if(tmp1[i] == tmp2[j]) {
					array[i][j] = array[i-1][j-1] + 1;
				}
			}
		}
		
		System.out.println(array[str1Length][str2Length]);
		
	}
}
