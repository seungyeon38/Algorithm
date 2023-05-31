package class4_2;

import java.util.*;
import java.io.*;

public class boj12865_평범한배낭_252ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수 1~100
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게 1~100000
		
		int[][] things = new int[N+1][2]; // 물건 (무게, 가치)
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); // 물건의 무게 1~100000
			things[i][1] = Integer.parseInt(st.nextToken()); // 물건의 가치 0~1000
		}
		
		int[][] dp = new int[K+1][N+1];
		
		for(int i=1; i<=K; i++) { // 넣을 수 있는 무게 
			for(int j=1; j<=N; j++) { // 물건 
				if(things[j][0] <= i) { // 해당 물건을 넣을 수 있을 때 
					dp[i][j] = Math.max(dp[i-things[j][0]][j-1]+things[j][1], dp[i][j-1]);
				} else { // 넣을 수 없을 때 
					dp[i][j] = dp[i][j-1]; // 이전 물건까지의 값 
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
