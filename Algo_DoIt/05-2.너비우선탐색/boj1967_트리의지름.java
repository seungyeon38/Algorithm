package Algorithm;

import java.util.*;
import java.io.*;

public class boj1967 {
	static ArrayList<Node>[] tree;
	static boolean[] visited; 
	static int N; // 노드 10000
	static int max; 
	static int max_idx; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st; 
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree[s].add(new Node(e, w));
			tree[e].add(new Node(s, w));
		}
		
		dfs_recur(new Node(1, 0), 0);

		max = 0; 
		Arrays.fill(visited, false);

		if(max_idx != 0) dfs_recur(new Node(max_idx, 0), 0);
		
		System.out.println(max);
	}
	
	public static void dfs_recur(Node n, int weight) {
		if(visited[n.idx]) return; 
		
		visited[n.idx] = true; 
		
		for(Node node : tree[n.idx]) {
			if(!visited[node.idx]) {
				dfs_recur(node, weight+node.weight);
			}
		}
		
		if(max < weight) {
			max = weight; 
			max_idx = n.idx;
		}		
	}
	
	static class Node{
		int idx; 
		int weight;
		
		Node(int idx, int weight){
			this.idx = idx;
			this.weight = weight;
		}
	}
}
