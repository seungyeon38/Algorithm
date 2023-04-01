package class5;

import java.util.*;
import java.io.*;

public class boj10942_팰린드롬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N][N];
		// 길이 1
		for(int i=0; i<N; i++) {
			dp[i][i] = true;
		}
		// 길이 2 
		for(int i=1; i<N; i++) {
			if(nums[i-1] == nums[i]) {
				dp[i-1][i] = true;
			}
		}
		// 길이 3~N까지 
		for(int l=2; l<N; l++) {
			for(int i=l; i<N; i++) {
				if(nums[i-l]==nums[i] && dp[i-l+1][i-1]) {
					dp[i-l][i] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine()); // 1000000
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken())-1;
			int E = Integer.parseInt(st.nextToken())-1;
			
			if(dp[S][E]) {
				sb.append("1").append("\n");
			} else {
				sb.append("0").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
