package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표값2_2587 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = new int[5];
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			int num = Integer.parseInt(br.readLine());
			array[i] = num;
			sum += num; // 합 구하기
		}
		
		// 정렬
		Arrays.sort(array);
		
		System.out.println(sum/5); // 평균 구하기
		System.out.println(array[2]); // 중앙값 구하기

	}

}
