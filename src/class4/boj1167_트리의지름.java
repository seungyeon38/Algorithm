package class4;

import java.util.*;
import java.io.*;

public class boj1167_트리의지름 {
	static int V;
	static ArrayList<Node>[] grid; 
	static boolean[] visited;
	static int max, max_idx;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 100000
		
		grid = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			grid[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken()); 
			int n;
			while((n = Integer.parseInt(st.nextToken())) != -1) {
				int w = Integer.parseInt(st.nextToken()); 
				grid[s].add(new Node(n, w));
			}
		}
		
		visited = new boolean[V+1];
		max = 0;
		dfs(1, 0);
				
		visited = new boolean[V+1];
		dfs(max_idx, 0);
		
		System.out.println(max);
	}
	
	public static class Node{
		int e;
		int w; 
		
		Node(int e, int w){
			this.e = e;
			this.w = w; 
		}
	}
	
	public static void dfs(int s, int w) {
		if(w > max) {
			max = w;
			max_idx = s;
		}
		
		visited[s] = true; 
		
		for(Node n : grid[s]) {
			if(!visited[n.e]) {
				visited[n.e] = true; 
				dfs(n.e, w+n.w);
			}
		}
	}
}
