package Algorithm;

import java.io.*;
import java.util.*;

public class boj2606_바이러스 {
	static int N, M;
	static boolean[][] grid;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수 100
		M = Integer.parseInt(br.readLine()); 
		grid = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			grid[s][e] = true;
			grid[e][s] = true;
		}
		
		dfs(1);
		
		int result = 0; 
		for(int i=1; i<=N; i++) {
			if(visited[i]) result++;
		}
		
		System.out.println(result-1);
	}
	
	public static void dfs(int s) {
		visited[s] = true;

		for(int i=1; i<=N; i++) {
			if(visited[i] || !grid[s][i]) continue;
			dfs(i);
		}
	}
}
