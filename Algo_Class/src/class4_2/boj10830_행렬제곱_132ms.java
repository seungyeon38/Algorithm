package class4_2;

import java.util.*;
import java.io.*;

public class boj10830_행렬제곱_132ms {
	static int N; 
	static int[][] origin_matrix;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 2~5 
		long B = Long.parseLong(st.nextToken()); // 1~100000000000
		
		origin_matrix = new int[N][N]; // 행렬 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				origin_matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = pow(origin_matrix, B);
		StringBuilder sb = new StringBuilder(); 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]%1000).append(" "); 
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int[][] pow(int[][] matrix, long n){
		if(n == 1) return matrix; 
		
		int[][] result = pow(matrix, n/2);
		result = multiply(result, result);
		
		if(n%2 == 1) { // 홀수 
			result = multiply(result, origin_matrix);
		}
		
		return result; 
	}
	
	public static int[][] multiply(int[][] m1, int[][] m2){
		int[][] result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int temp = 0; 
				for(int k=0; k<N; k++) {
					temp += m1[i][k]*m2[k][j]; 
					// 0,0,k 00*00 + 01*10 + 02*20
					// 0,1,k 00*01 + 01*11 + 02*21
					// 0,2,k 00*02 + 01*12 + 02*22
				}
				
				result[i][j] = temp%1000; 
			}
		}
		
		return result; 
	}
}
