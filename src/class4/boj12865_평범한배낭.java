package class4;

import java.util.*;
import java.io.*;

public class boj12865_평범한배낭 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 1~100
		int K = Integer.parseInt(st.nextToken()); // 1~100000
		
		int[][] things = new int[N+1][2]; // 물건 (0:무게, 1:가치)
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			things[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) { // 물건 
			int[] thing = things[i]; // 0:무게, 1:가치
			for(int j=1; j<=K; j++) { // 무게 
				dp[i][j] = dp[i-1][j];
				if(thing[0] <= j) {
					dp[i][j] = Math.max(dp[i][j], thing[1]+dp[i-1][j-thing[0]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
