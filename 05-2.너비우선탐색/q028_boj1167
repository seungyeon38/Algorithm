package Algorithm;

import java.util.*;
import java.io.*;

public class q028_boj1167{
	static ArrayList<Node>[] matrix;
	static boolean[] visited;
	static int V;
	static int max_idx; 
	static int max; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 100000
		
		matrix = new ArrayList[V+1];
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
				matrix[s].add(new Node(e, Integer.parseInt(st.nextToken())));
				e = Integer.parseInt(st.nextToken());
			}
		}
			
		dfs(new Node(1, 0), 0);
		
		Arrays.fill(visited, false);
		
		max = 0; 
	
		dfs(new Node(max_idx, 0), 0);
				
		System.out.println(max);
	}

	public static void dfs(Node n, int weight) {
		visited[n.idx] = true; 
		
		for(Node node : matrix[n.idx]) {
			if(!visited[node.idx]) {
				dfs(node, weight+node.weight);
			}
		}
		
		if(max < weight) {
			max = weight;
			max_idx = n.idx;
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
