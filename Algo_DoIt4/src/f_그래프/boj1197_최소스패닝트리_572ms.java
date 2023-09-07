package f_그래프;

import java.util.*;
import java.io.*;

public class boj1197_최소스패닝트리_572ms {
	static int[] parents; 
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~10000
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수 1~100000
		PriorityQueue<Edge> edge_list = new PriorityQueue<>();
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // -1000000~1000000
			
			edge_list.add(new Edge(A, B, C));
		}
		
		int result = 0;
		while(!edge_list.isEmpty()) {
			Edge edge = edge_list.poll();
			
			if(find(edge.s) == find(edge.e)) continue; 
			
			union(edge.s, edge.e);
			result += edge.w;
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
		if(parents[n] == n) return n;
		
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
