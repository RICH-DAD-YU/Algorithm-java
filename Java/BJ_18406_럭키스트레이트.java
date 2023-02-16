package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 럭키스트레이트_18406 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int strLength = str.length();
		
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < strLength/2; i++) {
			num1 += (str.charAt(i) - '0');
		}
		for (int i = strLength/2; i < strLength; i++) {
			num2 += (str.charAt(i) - '0');
		}
		
		if(num1 == num2) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
	}
}
