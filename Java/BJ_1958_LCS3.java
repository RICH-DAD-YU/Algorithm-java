package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS3_1958 {

	static int[][][] LCS;

	static char[] array1;
	static char[] array2;
	static char[] array3;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 번째 문자열
		String str1 = br.readLine();
		int str1Length = str1.length();
		array1 = new char[str1Length + 1];
		for (int i = 0; i < str1Length; i++) {
			array1[i + 1] = str1.charAt(i);
		}

		String str2 = br.readLine();
		int str2Length = str2.length();
		array2 = new char[str2Length + 1];
		for (int i = 0; i < str2Length; i++) {
			array2[i + 1] = str2.charAt(i);
		}

		String str3 = br.readLine();
		int str3Length = str3.length();
		array3 = new char[str3Length + 1];
		for (int i = 0; i < str3Length; i++) {
			array3[i + 1] = str3.charAt(i);
		}

		LCS = new int[str1Length + 1][str2Length + 1][str3Length + 1];

		for (int i = 0; i < str1Length+1; i++) {
			for (int j = 0; j < str2Length+1; j++) {
				for (int k = 0; k < str3Length+1; k++) {
					// 마진을 0으로 채운다
					if (i == 0 || j == 0 || k == 0) {
						LCS[i][j][k] = 0;
					// 모든 문자가 같다면
					} else if (array1[i] == array2[j] && array2[j] == array3[k]) {
						LCS[i][j][k] = LCS[i - 1][j - 1][k - 1] + 1;
					
					} else {
						LCS[i][j][k] = Math.max(LCS[i - 1][j][k], Math.max(LCS[i][j - 1][k], LCS[i][j][k - 1]));
					}
				}
			}
		}
		System.out.println(LCS[str1Length][str2Length][str3Length]);
	}
}
