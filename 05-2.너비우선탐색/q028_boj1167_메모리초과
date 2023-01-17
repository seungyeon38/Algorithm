package Algorithm;

import java.util.*;
import java.io.*;

public class q028_boj1167_메모리초과 {
	static int[][] matrix;
	static boolean[] visited;
	static int V;
	static int max_idx; 
	static int max; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 100000
		
		matrix = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		StringTokenizer st;
		
		for(int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			while(e != -1) {
				matrix[s][e] = Integer.parseInt(st.nextToken());
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
		
		for(int i=1; i<=V; i++) {
			if(matrix[n][i] != 0 && !visited[i]) {
				dfs(i, weight+matrix[n][i]);
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
