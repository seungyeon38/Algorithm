package 조합;

import java.util.*;
import java.io.*;

public class q078_boj2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[15][15];
		// a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합
		// 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
		
		for(int i=0; i<15; i++) {
			dp[0][i] = i;
		}
		
		for(int i=0; i<15; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		for(int i=1; i<15; i++) { // 층 
			for(int j=1; j<15; j++) { // 호 
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			int k = Integer.parseInt(br.readLine()); // 층 1~14
			int n = Integer.parseInt(br.readLine()); // 호 1~14 
			
			sb.append(dp[k][n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
