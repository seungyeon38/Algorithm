package 그래프;

import java.util.*;
import java.io.*; 

public class q064_boj1197_최소스패닝트리 {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 1~10000
		int E = Integer.parseInt(st.nextToken()); // 1~100000
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); 
			
			pq.add(new Edge(A, B, C));
		}
	
		parents = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		int i=0; 
		while(i < V-1) {
			Edge edge = pq.poll();
			
			if(find(edge.s) == find(edge.e)) continue; // 사이클X
			
			result += edge.w;
			union(edge.s, edge.e);
			i++;
		}
		
		System.out.println(result);
	}
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return; 
		
		parents[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(n == parents[n]) return n; 
		
		return parents[n] = find(parents[n]);
	}
	
	public static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w; 
		
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w; 
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}
}
