package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기_1744 {
	
	static int N;
	
	static int minusNum;
	static int plusNum;
	
	static int oneNum;
	
	static boolean existZero;
	static boolean existOne;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 양수, 음수 1의 개수
		minusNum = 0;
		plusNum = 0;
		oneNum = 0;
		
		List<Integer> minus = new ArrayList<Integer>();
		List<Integer> plus = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			
			int k = Integer.parseInt(br.readLine());
			
			if(k < 0) {
				minusNum++;
				minus.add(k);
			}else if(k == 0) {
				existZero = true;
			}else if(k == 1) {
				existOne = true;
				oneNum++;
			}else if(k > 1) {
				plusNum++;
				plus.add(k);
			}
		}
		
		// 정렬(양수는 역순으로 - 그래야 최댓값을 구할 수 있음(5, 4, 3, 2, ...)
		Collections.sort(minus);
		Collections.sort(plus, (e1, e2) -> { return e2 - e1; });
		
		int ans = 0;
		
		// 음수에서 최댓값 구하기
		// 음수의 개수가 하나이고, 0이 존재하지 않는다면 값에 음수를 더해줌
		// 0이 존재할 경우 곱해서 음수를 0으로 만드므로 굳이 계산 로직에 넣지 않음
		if(minusNum == 1) {
			if(existZero == false) {
				ans += minus.get(0);
			}
			// 음수의 개수가 짝수일 때
		}else if(minusNum % 2 == 0) {
			int repeat = minusNum / 2;
			int tmp = 0;
			for (int i = 0; i < repeat; i++) {
				int multi = (minus.get(tmp) * minus.get(tmp+1));
				ans += multi;
				tmp += 2;
			}
			// 짝수가 아닐 때, 최후에 1개가 남으므로 0이 존재하지 않을 시 정답에 더해줌
		}else if(minusNum % 2 != 0) {
			int repeat = minusNum / 2;
			int tmp = 0;
			for (int i = 0; i < repeat; i++) {
				int multi = (minus.get(tmp) * minus.get(tmp+1));
				ans += multi;
				tmp += 2;
			}
			if(existZero == false) {
				ans += minus.get(minusNum-1);
			}
		}
		
		// 1존재 시(1이 여러 개 나올 경우만큼 정답에 더해주었음)
		if(existOne == true) {
			for (int i = 0; i < oneNum; i++) {
				ans++;
			}
		}
		
		// 1제외한 양수에서 최댓값 구하기
		// 음수를 구할 때와 로직이 비슷하므로 자세한 설명은 생략
		if(plusNum == 1) {
			ans += plus.get(0);
		}else if(plusNum % 2 == 0) {
			int repeat = plusNum / 2;
			int tmp = 0;
			for (int i = 0; i < repeat; i++) {
				int multi = (plus.get(tmp) * plus.get(tmp+1));
				ans += multi;
				tmp += 2;
			}
		}else if(plusNum % 2 != 0) {
			int repeat = plusNum / 2;
			int tmp = 0;
			for (int i = 0; i < repeat; i++) {
				int multi = (plus.get(tmp) * plus.get(tmp+1));
				ans += multi;
				tmp += 2;
			}
			ans += plus.get(plusNum-1);
		}
		System.out.println(ans);
	}
}
