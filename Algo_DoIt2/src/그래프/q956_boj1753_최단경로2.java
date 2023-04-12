package 그래프;

import java.util.*;
import java.io.*;

public class q956_boj1753_최단경로2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int V = Integer.parseInt(st.nextToken()); // 정점 개수 1~20000
		int E = Integer.parseInt(st.nextToken()); // 간선 개수 1~300000
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호 
		
		ArrayList<Node>[] adj_list = new ArrayList[V+1];
		
		for(int i=0; i<=V; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 1~10 
			
			adj_list[u].add(new Node(v, w));
		}
		 
		// K부터 다른 노드까지의 거리 
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(K, 0));
		distance[K] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(Node next : adj_list[node.n]) {
				if(distance[next.n] > node.w+next.w) {
					distance[next.n] = node.w+next.w;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
			
		StringBuilder sb = new StringBuilder(); 
		for(int i=1; i<=V; i++) {
			if(distance[i] < Integer.MAX_VALUE) {
				sb.append(distance[i]).append("\n");
			} else {
				sb.append("INF").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int w; 
		
		Node(int n, int w){
			this.n = n; 
			this.w = w;
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
}
