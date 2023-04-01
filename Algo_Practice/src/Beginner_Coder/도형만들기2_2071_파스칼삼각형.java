package Beginner_Coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도형만들기2_2071_파스칼삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 높이 
		int m = Integer.parseInt(st.nextToken()); // 종류 
		int[][] arr = new int[n][n];
		
		switch(m) {
		case 1:
			print1(arr, n);
			break;
		case 2:
			print2(arr, n);
			break;
		case 3:
			print3(arr, n);
			break;
		}
		
		
	}
	
	public static void print1(int[][] arr, int n) {
		// 1
		// 1 1
		// 1 2 1
		// 1 3 3 1
		// 1 4 6 4 1
		arr[0][0] = 1;
		for(int i=1; i<n; i++){
			arr[i][0] = 1;
			for(int j=1; j<i; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
			arr[i][i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	public static void print2(int[][] arr, int n) {
		// 1 4 6 4 1	5 0
		//  1 3 3 1		4 1
		//   1 2 1		3 2
		//    1 1 		2 3
		//     1		1
		
		// 1 4 6 4 1
		// 1 3 3 1
		// 1 2 1
		// 1 1 
		// 1
		arr[n-1][0] = 1;
		for(int i=n-2; i>=0; i--) {
			int size = n-i-1;
			arr[i][0] = 1;
			for(int j=1; j<size; j++) {
				arr[i][j] = arr[i+1][j-1] + arr[i+1][j];
			}
			arr[i][size] = 1;
		}
		
		StringBuilder sb = new StringBuilder();

		int c;
		for(int i=n; i>0; i--) {
			c = n-i;
			for(int j=c; j>0; j--) {
				sb.append(' ');
			}
			for(int j=0; j<i; j++) {
				sb.append(arr[c][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	public static void print3(int[][] arr, int n) {
		// 1			44
		// 4 1			33 43
		// 6 3 1		22 42
		// 4 3 2 1		11 41
		// 1 1 1 1 1 	00 40 
		
		arr[n-1][n-1] = 1;
		for(int i=n-2; i>=0; i--) {
			arr[i][i] = 1;
			for(int j=i+1, size=n-1; j<size; j++) {
				arr[j][i] = arr[j][i+1] + arr[j+1][i+1];
			}
			arr[n-1][i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0, size=i+1; j<size; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
