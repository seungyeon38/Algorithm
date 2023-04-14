package 조합;

import java.util.*;
import java.io.*;

public class q077_boj11051_이항계수2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1~1000
		int K = Integer.parseInt(st.nextToken());
		
		// N개 중에 K개 고르기 
		int[][] dp = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1; 
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
