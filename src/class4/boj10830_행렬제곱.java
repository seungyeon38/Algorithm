package class4;

import java.util.*;
import java.io.*;

public class boj10830_행렬제곱 {
	static int N;
	static int[][] A;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 2~5
		long B = Long.parseLong(st.nextToken()); // 1~100000000000
		
		A = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] result = recur(B);
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int[][] recur(long n) {
		if(n == 1) return A;
		
		int[][] half = recur(n/2);
		int[][] result = multiply(half, half);
		
		if(n%2 == 0) { // 짝수 
			return result;
		} else { // 홀수 
			return multiply(result, A);
		}
	}
	
	public static int[][] multiply(int[][] m1, int[][] m2) {
		int[][] result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					result[i][j] += m1[i][k]*m2[k][j];
					result[i][j] %= 1000;
				}
			}
		}
		
		return result;
	}
}
