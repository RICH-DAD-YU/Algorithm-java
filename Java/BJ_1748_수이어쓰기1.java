package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수이어쓰기1_1748 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		int tmp1 = 9;
		int tmp2 = 180;
		int tmp3 = 2700;
		int tmp4 = 9000*4;
		int tmp5 = 90000*5;
		int tmp6 = 900000*6;
		int tmp7 = 9000000*7;
		int tmp8 = 90000000*8;
		
		if(N < 10) {
			System.out.println(N);
		}else if(10 <= N && N < 100) {
			int tmp = (N - 9)*2;
			System.out.println(tmp1 + tmp);			
		}else if(100 <= N && N < 1000) {
			int tmp = (N - 99)*3;
			System.out.println(tmp1 + tmp2 + tmp);
		}else if(1000 <= N && N < 10000) {
			int tmp = (N - 999)*4;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp);
		}else if(10000 <= N && N < 100000) {
			int tmp = (N - 9999)*5;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp4 + tmp);
		}else if(10000 <= N && N < 100000) {
			int tmp = (N - 99999)*6;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp4 + tmp5 + tmp);
		}else if(1000000 <= N && N < 10000000) {
			int tmp = (N - 999999)*7;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp4 + tmp5 + tmp6 + tmp);
		}else if(10000000 <= N && N < 100000000) {
			int tmp = (N - 9999999)*8;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp4 + tmp5 + tmp6 + tmp7 + tmp);
		}else if(100000000 <= N && N < 1000000000) {
			int tmp = (N - 99999999)*9;
			System.out.println(tmp1 + tmp2 + tmp3 + tmp4 + tmp5 + tmp6 + tmp7 + tmp8 + tmp);
		}
	}
}
