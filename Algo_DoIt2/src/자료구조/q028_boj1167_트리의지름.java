package 자료구조;

import java.util.*;
import java.io.*;

public class q028_boj1167_트리의지름 {
	static int V;
	static ArrayList<Node>[] adj_list;
	static int max_distance, max_n; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); // 2~100000
		adj_list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int n_idx = Integer.parseInt(st.nextToken());
			while(n_idx != -1) {
				int distance = Integer.parseInt(st.nextToken());
				adj_list[idx].add(new Node(n_idx, distance));
				n_idx = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(1);
		bfs(max_n);
		
		System.out.println(max_distance);
	}
	
	public static class Node{
		int n; 
		int distance; 
		
		Node(int n, int distance){
			this.n = n; 
			this.distance = distance; 
		}
	}
	
	public static void bfs(int n) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[] visited = new boolean[V+1];
		
		queue.add(new Node(n, 0));
		max_distance = 0; 
		max_n = 0;
		visited[n] = true; 
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(max_distance < node.distance) {
				max_distance = node.distance;
				max_n = node.n;
			}
			
			for(Node n_node : adj_list[node.n]) {
				if(!visited[n_node.n]) {
					visited[n_node.n] = true; 
					queue.add(new Node(n_node.n, node.distance+n_node.distance));
				}
			}
		}
	}
}
