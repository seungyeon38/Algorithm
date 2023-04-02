package 자료구조;

import java.util.*;
import java.io.*;

public class q023_boj11724_연결요소의개수 {
	static int N, M; 
	static boolean[] visited; 
	static List<Integer>[] adj_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드의 개수 1~1000
		M = Integer.parseInt(st.nextToken()); // 에지의 개수 
		adj_list = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adj_list[s].add(e);
			adj_list[e].add(s);
		}
		
		visited = new boolean[N+1];
		int cnt = 0; 
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int s) {
		if(visited[s]) return; 
		
		visited[s] = true; 
		for(int n : adj_list[s]) {
			if(!visited[n]) dfs(n);
		}
	}
}
