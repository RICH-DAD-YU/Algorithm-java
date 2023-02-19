package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class 공통부분문자열_5582 {

	static int[][] array;
	
	static char[] tmp1; // 첫 번째 문자열
	static char[] tmp2; // 두 번째 문자열
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 문자열 - tmp1 배열에 담기
		String str1 = br.readLine();
		int str1Length = str1.length();
		tmp1 = new char[str1Length+1];
		for (int i = 0; i < str1Length; i++) {
			tmp1[i+1] = str1.charAt(i);
		}
		
		// 두 번째 문자열 - tmp2 배열에 담기
		String str2 = br.readLine();
		int str2Length = str2.length();
		tmp2 = new char[str2Length+1];
		for (int i = 0; i < str2Length; i++) {
			tmp2[i+1] = str2.charAt(i);
		}
		// 배열 초기화
		array = new int[str1Length+1][str2Length+1];
		
		int ans = 0;
		for (int i = 0; i < str1Length+1; i++) {
			for (int j = 0; j < str2Length+1; j++) {
				// 마진을 0으로 채움
				if(i == 0 || j == 0) {
					array[i][j] = 0;
					// 다르면 array값은 0
				}else if(tmp1[i] != tmp2[j]) {
					array[i][j] = 0;
					//같으면 좌상 배열값에 +1
				}else if(tmp1[i] == tmp2[j]) {
					array[i][j] = array[i-1][j-1] + 1;
					ans = Math.max(ans, array[i][j]);
				}	
			}
		}

		System.out.println(ans);
	}
}