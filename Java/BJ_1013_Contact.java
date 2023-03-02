package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contact_1013 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String vega = "(100+1+|01)+"; // 문제에서 주어진 정규표현식
		
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			
			// 주어진 문자열이 정규식과 일치한다면
			if(str.matches(vega)) {
				System.out.println("YES");
			// 주어진 문자열이 정규식과 일치하지 않는다면
			}else {
				System.out.println("NO");
			}
		}	
	}
}