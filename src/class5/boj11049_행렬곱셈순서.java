package class5;

import java.util.*;
import java.io.*;

public class boj11049_행렬곱셈순서 {
	static int[][] arr; 
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~500
		arr = new int[N][2];
		dp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) dp[i][j] = 0;
				else dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1; i<N; i++) { // 간격 
			for(int s=0; s+i<N; s++) {
				multipleMatrix(s, s+i);
			}
		}
		
		System.out.println(dp[0][N-1]);
	}
	
	public static void multipleMatrix(int sp, int ep) {
		for(int i=sp; i<ep; i++) {
			int cost = dp[sp][i]+dp[i+1][ep]+arr[sp][0]*arr[i][1]*arr[ep][1];
			dp[sp][ep] = Math.min(dp[sp][ep], cost);
		}
	}
}
