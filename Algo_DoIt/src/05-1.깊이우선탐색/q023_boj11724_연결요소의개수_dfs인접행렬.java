package Algorithm;

import java.util.*;
import java.io.*;

public class q023_boj11724_dfs인접행렬 {
	public static boolean[][] matrix;
	public static boolean[] visited;
	public static int N; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 1000
		int M = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			matrix[s][e] = true; 
			matrix[e][s] = true;
		}	
		
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				result++;
				dfs(i);
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int v) {
		if(visited[v]) {
			return; 
		}
		
		visited[v] = true; 
		
		for(int i=1; i<=N; i++) {
			if(matrix[v][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}
