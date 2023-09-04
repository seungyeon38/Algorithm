package c_탐색;

import java.util.*;
import java.io.*;

public class boj11724_연결요소의개수_696ms {
	static boolean[] visited;
	static ArrayList<Integer>[] adj_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수 1~1000
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수 0~N*(N-1)/2
		
		visited = new boolean[N+1];
		adj_list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj_list[u].add(v);
			adj_list[v].add(u);
		}
		
		int result = 0; 
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue; 
			
			dfs(i);
			result++;
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int n) {
		if(visited[n]) return; 
		
		visited[n] = true; 
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue;
			
			dfs(next);
		}
	}
}
