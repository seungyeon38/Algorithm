package class5_2;

import java.util.*;
import java.io.*;

public class boj17404_RGB거리2_140ms_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 집의 수 2~1000
		int[][] cost = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][3];
		int result = 1000001;
		
		for(int s=0; s<3; s++) { // 첫번째 집 
			for(int i=0; i<3; i++) {
				if(s == i) dp[0][i] = cost[0][i];
				else dp[0][i] = 1000001;
			}

			for(int i=1; i<N; i++) {
				dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
			
			for(int i=0; i<3; i++) { 
				if(i != s) result = Math.min(result, dp[N-1][i]);
			}
		}

		System.out.println(result);
	}
}
