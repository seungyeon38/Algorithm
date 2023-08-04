package 그래프;

import java.util.*;
import java.io.*;

public class boj1854_K번째최단경로찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시들의 개수 1~1000
		int m = Integer.parseInt(st.nextToken()); // 도시 간에 존재하는 도로 수 1~2000000
		int k = Integer.parseInt(st.nextToken()); // 1~100
		
		ArrayList<Node>[] adj_list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 1~1000
			
			adj_list[a].add(new Node(b, c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));
		PriorityQueue<Integer>[] distance = new PriorityQueue[n+1];
		for(int i=0; i<=n; i++) {
			distance[i] = new PriorityQueue<Integer>();
		}
		distance[1].add(0);
		boolean[] visited = new boolean[n+1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next : adj_list[cur.n]) {
				if(distance[next.n].size() < k) { // 
					
				} else {
					
				} 
			}
		}
		
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
