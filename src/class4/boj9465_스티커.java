package class4;

import java.util.*;
import java.io.*;

public class boj9465_스티커 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine()); // 100000
			int[][] score = new int[2][n];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					score[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			int[][] dp = new int[2][n];
			dp[0][0] = score[0][0];
			dp[1][0] = score[1][0];
			
			if(n == 1) {
				System.out.println(Math.max(dp[0][0], dp[1][0]));
				continue;
			}
			
			dp[0][1] = dp[1][0] + score[0][1];
			dp[1][1] = dp[0][0] + score[1][1];
			
			for(int j=2; j<n; j++) {
				for(int i=0; i<2; i++) {
					dp[i][j] = Math.max(dp[Math.abs(i-1)][j-2], dp[Math.abs(i-1)][j-1]) + score[i][j];
				}
			}
						
			sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
