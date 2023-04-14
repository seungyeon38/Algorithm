package 조합;

import java.util.*;
import java.io.*;
 
public class q076_boj11050_이항계수1_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~10
		int K = Integer.parseInt(st.nextToken());
		
		// N개중에 K개 뽑기 
		int[][] dp = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i][0] = 1; // i개 중에 0개를 뽑는 경우의 수 
			dp[i][1] = i; // i개 중에 1개를 뽑는 경우의 수 
			dp[i][i] = 1; // i개 중에 i개를 뽑는 경우의 수 
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
