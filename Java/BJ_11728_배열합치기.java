package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열합치기_11728 {

	static int N, M;

	static int[] array;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 각 배열의 크기를 더해서 하나의 배열을 만듬
		array = new int[N+M];
		
		// 순서에 맞게 값 삽입
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N+M; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(array);
		
		// BufferedWriter를 쓰지 않으면 시간 초과 발생
		for (int i = 0; i < N+M; i++) {
			bw.write(array[i] + " ");
		}
		bw.close();
	}
}
