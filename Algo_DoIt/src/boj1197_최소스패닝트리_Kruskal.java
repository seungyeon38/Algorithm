package Algorithm;

import java.util.*;
import java.io.*;

public class boj1197_최소스패닝트리_Kruskal {
	static Edge[] edge_list; 
	static int[] parent; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점 10000
		int E = Integer.parseInt(st.nextToken()); // 간선 100000
		
		edge_list = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			edge_list[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		parent = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(edge_list);
		
		int weight = 0;
		for(int i=0; i<E; i++) {
			Edge edge = edge_list[i];
			
			if(find(edge.s) != find(edge.e)) {
				weight += edge.w;
				union(edge.s, edge.e);
			}
		}
		
		System.out.println(weight);
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
	
	public static void union(int n1, int n2) {
		int n1_p = find(n1);
		int n2_p = find(n2);
		
		if(n1_p == n2_p) return; 
		
		parent[n1_p] = n2_p;
	}
	
	public static int find(int n) {
		if(parent[n] == n) return n;
		
		return parent[n] = find(parent[n]);
	}
}
