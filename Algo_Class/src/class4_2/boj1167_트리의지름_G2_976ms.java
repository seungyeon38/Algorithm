package class4_2;

import java.util.*;
import java.io.*; 

public class boj1167_트리의지름_G2_976ms {
	static ArrayList<Node>[] adj_list;
	static int[] distance; 
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); // 정점 개수 2~100000
		adj_list = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			while(next != -1) {
				int d = Integer.parseInt(st.nextToken());
				adj_list[n].add(new Node(next, d));
				
				next = Integer.parseInt(st.nextToken());
			}
		}
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[V+1];
		distance[1] = 0;
		dijkstra(1);
		int max = 0;
		int max_idx = -1;
		for(int i=1; i<=V; i++) {
			if(max < distance[i]) {
				max = distance[i];
				max_idx = i;
			}
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		distance[max_idx] = 0;
		dijkstra(max_idx);
		
		max = 0;
		for(int i=1; i<=V; i++) {
			if(max < distance[i]) {
				max = distance[i];
			}
		}
		
		System.out.println(max);
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
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
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
}
