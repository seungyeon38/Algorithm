package 트리;

import java.util.*;
import java.io.*;

public class q074_boj11437_LCA {
	static boolean[] visited; 
	static ArrayList<Integer>[] adj_list;
	static int[][] node_info;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st; 
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adj_list[s].add(e);
			adj_list[e].add(s);
		}
		
		node_info = new int[N+1][2]; // 0:부모노드 1:깊이 
		visited = new boolean[N+1];
		
		dfs(1, 1);
		
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(node_info[i]));
//		}
		StringBuilder sb = new StringBuilder(); 
		
		int M = Integer.parseInt(br.readLine()); 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			sb.append(findParent(c1, c2)).append("\n"); 
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int cnt) {
		visited[n] = true; 
		
		for(int next : adj_list[n]) {
			if(visited[next]) continue; 
			node_info[next][0] = n;
			node_info[next][1] = cnt;
			visited[next] = true;
			dfs(next, cnt+1);
		}
	}
	
	public static int findParent(int c1, int c2) {
		// c1, c2 깊이 같게 
		if(node_info[c1][1] < node_info[c2][1]) {
			int temp = c1;
			c1 = c2;
			c2 = temp; 
		}
		
		while(node_info[c1][1] != node_info[c2][1]) {
			c1 = node_info[c1][0];  
		}
		
		while(c1 != c2) {
			c1 = node_info[c1][0];
			c2 = node_info[c2][0];
		}
		
		return c1; 
	}
}
