package 트리;

import java.util.*;
import java.io.*;

public class q075_boj11438_LCA2__ {
	static boolean[] visited; 
	static ArrayList<Integer>[] adj_list;
	static int[] depths;
	static int max_depth; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 2~100000
		
		adj_list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(n2);
			adj_list[n2].add(n1);
		}
		
		visited = new boolean[N+1];
		depths = new int[N+1];
		
		dfs(1);
		
		
	}
	
	public static void dfs(int n) {
		if(visited[n]) return; 
		
		visited[n] = true; 
		for(int next : adj_list[n]) {
			if(visited[next]) continue;
			depths[next] = depths[n]+1;
			dfs(next); 
		}
		
		if(max_depth < depths[n]) max_depth = depths[n];
	}
}
