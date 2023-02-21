package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전형적인 투포인터 문제
public class 수들의합2_2003 {

	static int N, M;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		int start = 0;
		int end = 0;
		
		int cnt = 0;
		int tmp = 0;
		int sum = M;

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기 시작 인덱스부터 초기 끝 인덱스까지 더해주기 
		for (int i = start; i <= end; i++) {
			tmp += array[i];
		}
		
		// 투포인터
		// start가 마지막에 도달할 때까지 반복문 돌리기
		while(start < N) {
			
			// tmp와 sum이 같다면
			if(tmp == sum) {
				cnt++; //cnt를 더해주고
				start++;
				// end가 배열의 범위를 넘어서지 않는다면
				if(end + 1 < N) {
					end++;
					tmp += array[end];
				}
				// 인덱스 start를 하나 증가시켰으므로 원래 start 인덱스 값은 제거
				tmp -= array[start-1];
			// tmp가 sum 보다 작다면 end를 하나 늘려서 더해줘야 함
			}else if(tmp < sum) {
				if(end + 1 < N) {
					end++;
					tmp += array[end];
				}else {
					break;
				}
			// tmp가 sum보다 크다면 tmp에서 현재 start인덱스 값을 제거
			}else if(tmp > sum) {
				tmp -= array[start];
				start++;
			}
		}
		
		System.out.println(cnt);

	}

}
