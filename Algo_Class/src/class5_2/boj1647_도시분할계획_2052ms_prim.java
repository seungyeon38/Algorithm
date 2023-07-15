package class5_2; 

import java.util.*;
import java.io.*;

public class boj1647_도시분할계획_2052ms_prim {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수 2~100000
		int M = Integer.parseInt(st.nextToken()); // 길의 개수 1~1000000
		
		ArrayList<Node>[] adj_list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj_list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj_list[s].add(new Node(e, c));
			adj_list[e].add(new Node(s, c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));
		
		int result = 0; 
		int max = 0;
		boolean[] visited = new boolean[N+1];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue; 
			
			visited[cur.n] = true; 
			result += cur.cost;
			max = Math.max(max, cur.cost);
			
			for(Node next : adj_list[cur.n]) {
				if(visited[next.n]) continue; 
				
				pq.add(next);
			}
		}
		
		System.out.println(result-max);
	}
	
	public static class Node implements Comparable<Node>{
		int n;
		int cost;
		
		Node(int n, int c){
			this.n = n; 
			this.cost = c;
		}
		
		@Override 
		public int compareTo(Node n) {
			return this.cost-n.cost;
		}
	}
}
