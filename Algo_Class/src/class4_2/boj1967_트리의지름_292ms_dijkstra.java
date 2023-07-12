package class4_2;

import java.util.*;
import java.io.*;

public class boj1967_트리의지름_292ms_dijkstra {
	static int n;
	static ArrayList<Node>[] adj_list;
	static int[] dist; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); // 노드의 개수 1~10000
		adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(new Node(n2, c));
			adj_list[n2].add(new Node(n1, c));
		}
		
		dijkstra(1);

		int max = 0;
		int max_node = 0; 
		for(int i=2; i<=n; i++) {
			if(max<dist[i] && dist[i]!=Integer.MAX_VALUE) {
				max = dist[i]; 
				max_node = i;
			}
		}
		
		dijkstra(max_node);

		int result = 0;
		for(int i=1; i<=n; i++) {
			if(result<dist[i] && dist[i]!=Integer.MAX_VALUE) result = dist[i];
		}
		
		System.out.println(result);
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : adj_list[cur.n]) {
				if(dist[next.n] > dist[cur.n]+next.cost) {
					dist[next.n] = dist[cur.n]+next.cost;
					pq.add(new Node(next.n, dist[next.n]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int n; 
		int cost;
		
		Node(int n, int cost){
			this.n = n; 
			this.cost = cost; 
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.cost-n.cost;
		}
	}
}
