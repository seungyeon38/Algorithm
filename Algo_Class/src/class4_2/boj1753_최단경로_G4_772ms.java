package class4_2;

import java.util.*;
import java.io.*;

public class boj1753_최단경로_G4_772ms {
	static ArrayList<Node>[] adj_list;
	static int V;
	static int[] distance; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수 1~20000
		int E = Integer.parseInt(st.nextToken()); // 간선 개수 1~300000
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호 
		adj_list = new ArrayList[V+1];
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
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(distance[i]!=Integer.MAX_VALUE) sb.append(distance[i]).append("\n");
			else sb.append("INF").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		boolean[] visited = new boolean[V+1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true; 
			
			for(Node next : adj_list[cur.n]) {
				if(visited[next.n]) continue; 
				if(distance[next.n] > distance[cur.n]+next.distance) {
					distance[next.n] = distance[cur.n]+next.distance;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int n; 
		int distance; 
		
		Node(int n, int distance){
			this.n = n; 
			this.distance = distance; 
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
}
