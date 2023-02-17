package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A와B_12904 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 문자열 입력받기
		String str1 = br.readLine();
		int str1Length = str1.length();
		// 두 번째 문자열 입력받기
		String str2 = br.readLine();
	
		
		while(true) {
			
			StringBuffer sb = new StringBuffer(str2);
			int str2Length = sb.length();
			
			// 문자열 길이가 같을 경우 비교해서 값 출력
			if(str1Length == str2Length) {
				// 문자열 동일할 경우
				if(str1.equals(sb.toString())) {
					System.out.println(1);
					return;
					// 문자열 동일하지 않을 경우
				}else {
					System.out.println(0);
					return;
				}
			// 문자열의 길이가 다를 때
			}else {
				// 1. 문자열 맨 마지막이 B 라면 B를 제거하고 뒤집기
				if(sb.charAt(str2Length-1) == 'B') {
					str2 = str2.substring(0, str2Length-1);
					sb = new StringBuffer(str2);
					// 뒤집기
					str2 = sb.reverse().toString();
					// 문자열 맨 마지막이 A라면
				}else if(sb.charAt(str2Length-1) == 'A'){
					str2 = str2.substring(0, str2Length-1);
				}
				
			}
		}

	}

}
