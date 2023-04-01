package class4;

import java.util.*;
import java.io.*;

public class boj1149_RGB거리_dp {
	static int N;
	static int[][] cost;
	static int[][] dp; 
	static int[] result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 1000
		cost = new int[N][3];
		dp = new int[N][3];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for(int i=0; i<3; i++) {
			dp[0][i] = cost[0][i];
		}
		
		System.out.println(Math.min(recur(N-1, 0), Math.min(recur(N-1, 1), recur(N-1, 2))));
	}
	
	public static int recur(int n, int color){
		if(dp[n][color] == 0) {
			if(color == 0) dp[n][color] = Math.min(recur(n-1, 1), recur(n-1, 2)) + cost[n][color];
			else if(color == 1) dp[n][color] = Math.min(recur(n-1, 0), recur(n-1, 2)) + cost[n][color];
			else dp[n][color] = Math.min(recur(n-1, 0), recur(n-1, 1)) + cost[n][color];
		}
		
		return dp[n][color];
	}
}
