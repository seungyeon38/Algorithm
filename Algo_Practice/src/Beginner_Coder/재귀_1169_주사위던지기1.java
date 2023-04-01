package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀_1169_주사위던지기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		switch(M) {
		case 1: 
			func1(0, N, arr);
			break;
		case 2:
			func2(0, N, arr);
			break;
		case 3: 
			func3(0, N, arr, new boolean[7]);
			break;
		}
	}
	
	// 주사위를 N번 던져서 나올 수 있는 모든 경우
	public static void func1(int idx, int n, int[] arr) {
		if(idx == n) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=6; i++) {
			arr[idx] = i;
			func1(idx+1, n, arr);
		}
	}
	
	// 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
	public static void func2(int idx, int n, int[] arr) {
		if(idx == n) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return; 
		}
		
		// 이전 수보다 같거나 더 큰 수들만 
		if(idx == 0) { // 맨 첫번째 수 일 때 
			for(int i=1; i<=6; i++) {
				arr[idx] = i;
				func2(idx+1, n, arr);
			}
		} else { // 맨 첫번째 수가 아닐 때
			int idx_1 = idx-1;
			for(int i=arr[idx_1]; i<=6; i++) {
				arr[idx] = i; 
				func2(idx+1, n, arr);
			}
		}
	}

	// 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
	public static void func3(int idx, int n, int[] arr, boolean[] isUsed) {
		if(idx == n) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return; 
		}
		
		for(int i=1; i<=6; i++) {
			if(!isUsed[i]) {
				arr[idx] = i;
				isUsed[i] = true; 
				func3(idx+1, n, arr, isUsed);
				isUsed[i] = false;
			}
		}
	}
	
//	// 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
//	public static void func3(int idx, int n, int[] arr) {
//		if(idx == n) {
//			for(int i=0; i<n; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//		
//		// 이전 수보다 더 큰 수들만 
//		if(idx == 0) {
//			for(int i=1; i<=6; i++) {
//				arr[idx] = i;
//				func3(idx+1, n, arr);
//			}
//		} else {
//			int start = arr[idx-1]+1;
//			for(int i=start; i<=6; i++) {
//				arr[idx] = i;
//				func3(idx+1, n, arr);
//			}
//		}
//	}
}
