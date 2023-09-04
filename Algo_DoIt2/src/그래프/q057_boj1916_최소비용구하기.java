package 그래프;

import java.util.*;
import java.io.*;

public class q057_boj1916_최소비용구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시 개수 1~1000
		int M = Integer.parseInt(br.readLine()); // 버스 개수 1~100000
		
		ArrayList<Node>[] adj_list = new ArrayList[N+1]; 
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		StringTokenizer st; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sp = Integer.parseInt(st.nextToken());
			int ep = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // 100000
			
			adj_list[sp].add(new Node(ep, cost));
		}
		
		st = new StringTokenizer(br.readLine()); 
		int sp = Integer.parseInt(st.nextToken());
		int ep = Integer.parseInt(st.nextToken());
		
		long[] distance = new long[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[sp] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(sp, 0));
		int result = 0; 
		
		boolean[] visited = new boolean[N+1]; 
		visited[sp] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			
			if(cur.n == ep) {
				result = cur.w;
				break;
			}
			
			for(Node next : adj_list[cur.n]) {
				if(!visited[next.n] && distance[cur.n]!=Integer.MAX_VALUE && distance[next.n] > distance[cur.n]+next.w) {
					visited[next.n] = true; 
					distance[next.n] = distance[cur.n]+next.w;
					pq.add(new Node(next.n, distance[next.n]));
				}
			}
		}
		
		System.out.println(result);
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
