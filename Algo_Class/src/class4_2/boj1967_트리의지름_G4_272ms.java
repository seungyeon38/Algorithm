package class4_2;

import java.util.*;
import java.io.*; 

public class boj1967_트리의지름_G4_272ms {
	static int n; 
	static ArrayList<Node>[] adj_list;
	static int[] distance;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 1~10000
		adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 1~100
			
			adj_list[n1].add(new Node(n2, d));
			adj_list[n2].add(new Node(n1, d));
		}
		
		dijkstra(1);
		int max = 0;
		int max_idx = 0; 
		for(int i=1; i<=n; i++) {
			if(distance[i]!=Integer.MAX_VALUE && max<distance[i]) {
				max = distance[i];
				max_idx = i;
			}
		}
		
		dijkstra(max_idx);
		max = 0;
		max_idx = 0; 
		for(int i=1; i<=n; i++) {
			if(distance[i]!=Integer.MAX_VALUE && max<distance[i]) {
				max = distance[i];
				max_idx = i;
			}
		}
		
		System.out.println(max);
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;

		boolean[] visited = new boolean[n+1];
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(visited[n.n]) continue; 
			visited[n.n] = true; 
			
			for(Node next : adj_list[n.n]) {
				if(visited[next.n]) continue; 
				
				if(distance[n.n] != Integer.MAX_VALUE && distance[next.n] > distance[n.n]+next.distance) {
					distance[next.n] = distance[n.n]+next.distance;
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
