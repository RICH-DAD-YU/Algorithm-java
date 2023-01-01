package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열복원하기_16967 {

	static int H, W, X, Y;
	static int[][] A, B;
	/**
	 * 배열 B의 크기
	 * (H + X) x (W + Y)
	 */
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		A = new int[H][W];
		B = new int[H+X][W+Y];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// A 배열 구하기(X에 따른 배열)
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = B[i][j];
			}
		}
		
		for (int i = H-X; i < H; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = B[i+X][j+Y];
			}
		}
		
		for (int i = X; i < H-1; i++) {
			for (int j = 0; j < Y; j++) {
				A[i][j] = B[i][j];
			}
		}
		
		for (int i = X; i < H-1; i++) {
			for (int j = W-Y; j < W; j++) {
				A[i][j] = B[i+X][j+Y];
			}
		}
		
		for (int i = X; i < H-X; i++) {
			for (int j = Y; j < W-Y; j++) {
				A[i][j] = B[i][j] - A[i-X][j-Y]; 
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
