package Algorithm;

import java.util.*;
import java.io.*;

public class q028_boj1167_메모리초과2{
	static ArrayList<Integer>[] matrix;
	static int[][] list; 
	static boolean[] visited;
	static int V;
	static int max_idx; 
	static int max; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 100000
		
		matrix = new ArrayList[V+1];
		list = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			matrix[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		
		for(int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			while(e != -1) {
				list[s][e] = Integer.parseInt(st.nextToken());
				matrix[s].add(e);
				e = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 0);
		
		Arrays.fill(visited, false);
		
		max = 0; 
	
		dfs(max_idx, 0);
				
		System.out.println(max);
	}

	public static void dfs(int n, int weight) {
		visited[n] = true; 
		
		for(int i : matrix[n]) {
			if(!visited[i]) {
				dfs(i, weight+list[n][i]);
			}
		}
		
		if(max < weight) {
			max = weight;
			max_idx = n;
		}
	}
	
	public static class Node {
		int idx;
		int weight; 
		
		Node(int idx, int weight){
			this.idx = idx;
			this.weight = weight; 
		}
	}
}
