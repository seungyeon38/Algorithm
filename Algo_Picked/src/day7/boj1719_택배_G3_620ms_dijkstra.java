package day7;

import java.util.*;
import java.io.*;

public class boj1719_택배_G3_620ms_dijkstra {
	static int n;
	static ArrayList<Node>[] adj_list;
	static int[] dist; 
	static int[] route;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 어떤 경로를 거칠지 정해서, 이를 경로표로 정리하는 것이 여러분이 할 일이다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 집하장 개수 1~200
		int m = Integer.parseInt(st.nextToken()); // 경로 개수 1~10000
		
		adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj_list[n1].add(new Node(n2, w));
			adj_list[n2].add(new Node(n1, w));
		}
		
		for(int i=1; i<=n; i++) {
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			route = new int[n+1];

			dijkstra(i);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		boolean[] visited = new boolean[n+1];
				
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			visited[cur.n] = true; 
			
			for(Node next: adj_list[cur.n]) {
				if(dist[next.n] > dist[cur.n]+next.w) {
					dist[next.n] = dist[cur.n]+next.w;
					route[next.n] = cur.n;
					pq.add(new Node(next.n, dist[next.n]));
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(i == s) sb.append("- ");
			else {
				sb.append(find(i, s)).append(" ");
			}
		}
		sb.append("\n");
	}
	
	public static int find(int n, int s) {
		if(route[n] == s) return n;
		return find(route[n], s);
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
