package class4;

import java.util.*;
import java.io.*;

public class boj1753_최단경로_다익스트라 {
	static ArrayList<Node>[] graph; 
	static int V,E,K;
	static int[] distance; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int INF = 3000001;
		
		V = Integer.parseInt(st.nextToken()); // 20000
		E = Integer.parseInt(st.nextToken()); // 300000
		K = Integer.parseInt(br.readLine()); // 시작 정점 
		
		// 한 정점에서 다른 정점들로 
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}
		
		distance = new int[V+1];
		Arrays.fill(distance, INF);
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(distance[i] == INF) sb.append("INF").append("\n");
			else sb.append(distance[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Node implements Comparable<Node>{
		int e;
		int w;
		
		Node(int e, int w){
			this.e = e; 
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w-n.w;
		}
	}
	
	public static void dijkstra(int s) {
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.offer(new Node(s, 0));
		distance[s] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			visited[node.e] = true;
			
			for(Node n : graph[node.e]) {
				if(!visited[n.e] && distance[n.e] > distance[node.e]+n.w) {
					distance[n.e] = distance[node.e]+n.w;
					pq.offer(new Node(n.e, distance[n.e]));
				}
			}
		}
	}
}
