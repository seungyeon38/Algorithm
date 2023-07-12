package class4_2;

import java.util.*;
import java.io.*;

public class boj1967_트리의지름_228ms_dfs {
	static int n;
	static ArrayList<Node>[] adj_list;
	static int[] dist; 
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 노드의 개수 1~10000
		adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(new Node(n2, c));
			adj_list[n2].add(new Node(n1, c));
		}
		
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		visited = new boolean[n+1];
		visited[1] = true; 
		dfs(1);
		int max = 0;
		int max_idx = 0; 
		for(int i=2; i<=n; i++) {
			if(max<dist[i] && dist[i]!=Integer.MAX_VALUE) {
				max = dist[i];
				max_idx = i;
			}
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[max_idx] = 0;
		Arrays.fill(visited, false);
		visited[max_idx] = true; 
		dfs(max_idx);
		int result = 0;
		for(int i=1; i<=n; i++) {
			if(result<dist[i] && dist[i]!=Integer.MAX_VALUE) {
				result = dist[i];
				max_idx = i;
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int n) {		
		for(Node next : adj_list[n]) {
			if(visited[next.n]) continue; 
			
			visited[next.n] = true; 
			dist[next.n] = dist[n]+next.cost;
			dfs(next.n);
		}
	}
	
	public static class Node{
		int n; 
		int cost;
		
		Node(int n, int cost){
			this.n = n; 
			this.cost = cost; 
		}
	}
}
