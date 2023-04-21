package day6;

import java.util.*;
import java.io.*;

public class boj2533_사회망서비스SNS_G3_2312ms {
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited;
	static int[][] dp; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 정점 개수 2~1000000
		StringTokenizer st;
		adj_list = new ArrayList[N+1];
		visited = new boolean[N+1];
		dp = new int[N+1][2]; // 0: 얼리 아답터가 아닌 경우, 1: 맞을 경우 
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj_list[u].add(v);
			adj_list[v].add(u);
		}
		
		dfs(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	// dp[부모][0] += dp[자식][1] +..
	// dp[부모][1] += Math.min(dp[자식][0], dp[자식][1]) + ..
	public static void dfs(int n) {
		visited[n] = true; 
		// 0: 얼리 아답터가 아닌 경우, 1: 맞을 경우 
		dp[n][0] = 0;
		dp[n][1] = 1; 
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			
			dfs(next);
			dp[n][0] += dp[next][1];
			dp[n][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
}
