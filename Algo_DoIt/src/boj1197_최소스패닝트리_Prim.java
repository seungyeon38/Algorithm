package Algorithm;

import java.util.*;
import java.io.*;

public class boj1197_최소스패닝트리_Prim {
	static int[] parent; 
	static ArrayList<Node>[] node_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 10000
		int E = Integer.parseInt(st.nextToken()); // 간선 100000
		
		boolean[] T = new boolean[V+1];
		
		node_list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			node_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			node_list[s].add(new Node(e, w));
			node_list[e].add(new Node(s, w));
		}
		
		Queue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(1, 0));
		boolean[] visited = new boolean[V+1];
		int result = 0; 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.to]) continue; 
			
			visited[node.to] = true; 
			result += node.w;
			for(Node n : node_list[node.to]) {
				if(!visited[n.to]) {
					pq.add(n);
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static class Node implements Comparable<Node>{
		int to; 
		int w; 
		
		Node(int to, int w) {
			this.to = to; 
			this.w = w;
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.w-n.w;
		}
	}
}
