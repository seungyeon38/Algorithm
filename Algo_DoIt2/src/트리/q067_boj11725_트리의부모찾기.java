package 트리;

import java.util.*;
import java.io.*;

public class q067_boj11725_트리의부모찾기 {
	static ArrayList<Integer>[] adj_list;
	static boolean[] visited;
	static int[] result; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수 2~100000
		
		adj_list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); 
			adj_list[s].add(e);
			adj_list[e].add(s);
		}
		
		// 루트 1 
		visited = new boolean[N+1];
		result = new int[N+1];

		dfs(1);
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=2; i<=N; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n) {
		visited[n] = true; 
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			result[next] = n;
			dfs(next);
		}
	}
}
