package class4_2;

import java.util.*;
import java.io.*;

public class boj2096_내려가기_G5_440ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1~100000
		int[][] score = new int[N][3];
		int[][][] dp = new int[N][3][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				dp[0][i][j] = score[0][i];
			}
		}
		
		for(int i=1; i<N; i++) {
			dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + score[i][0];
			dp[i][1][0] = Math.max(dp[i-1][0][0], Math.max(dp[i-1][1][0], dp[i-1][2][0])) + score[i][1];
			dp[i][2][0] = Math.max(dp[i-1][1][0], dp[i-1][2][0]) + score[i][2];
			dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + score[i][0];
			dp[i][1][1] = Math.min(dp[i-1][0][1], Math.min(dp[i-1][1][1], dp[i-1][2][1])) + score[i][1];
			dp[i][2][1] = Math.min(dp[i-1][1][1], dp[i-1][2][1]) + score[i][2];
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {
			max = Math.max(max, dp[N-1][i][0]);
			min = Math.min(min, dp[N-1][i][1]);
		}
		
		System.out.println(max + " " + min);
	}
}
