package 조합;

import java.util.*;
import java.io.*;

public class q079_boj1010_다리놓기_2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		long[][] dp = new long[31][31];
		
		for(int i=0; i<=30; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1;
		}
		
		for(int i=1; i<=30; i++) {
			for(int j=1; j<=30; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 0~30
			int M = Integer.parseInt(st.nextToken()); // 0~30
			
			// M개 중 N개 고르기 
			sb.append(dp[M][N]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
