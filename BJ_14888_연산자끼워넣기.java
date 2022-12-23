package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {

	static int N, size;
	static int[] number;
	static char[] operators; // 순열 나타낼 배열
	static int[] store;
	static boolean[] isSelected;
	static int max, min, tmp;
	
	static List<Character> operator = new ArrayList<Character>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		store = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			store[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		// 연산자 개수만큼 operator 리스트에 삽입
		while(store[0] > 0) {
			operator.add('+');
			store[0]--;
		}
		while(store[1] > 0) {
			operator.add('-');
			store[1]--;
		}
		while(store[2] > 0) {
			operator.add('*');
			store[2]--;
		}
		while(store[3] > 0) {
			operator.add('/');
			store[3]--;
		}
		
		size = operator.size();
		
		operators = new char[size];
		isSelected = new boolean[size];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		// 연산자들을 순열로 하여 모든 경우의 수 검사
		permutation(0);
		
		System.out.println(max);
		System.out.println(min);		
	}
	
	static void permutation(int cnt) {
		tmp = number[0];
		if(cnt == size) {
			for (int i = 0; i < N-1; i++) {
				switch(operators[i]) {
				case '+' :
					tmp += number[i+1];			
					break;
				case '-' :
					tmp -= number[i+1];
					break;
				case '*' :
					tmp *= number[i+1];
					break;
				case '/' :
					tmp /= number[i+1];
					break;
				}
			}
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
			return;
		}
		
		for (int i = 0; i < size; i++) {
			if(isSelected[i] == true) continue;
			
			operators[cnt] = operator.get(i);
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
