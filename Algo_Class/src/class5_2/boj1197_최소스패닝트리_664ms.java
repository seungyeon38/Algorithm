package class5_2;

import java.util.*;
import java.io.*;

public class boj1197_최소스패닝트리_664ms {
	public static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~10000
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수 1~100000
		
		parents= new int[V+1];
		for(int i=0; i<=V; i++) {
			parents[i] = i;
		}
		
		Edge[] edges = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(s, e, c);
		}
		
		Arrays.sort(edges);
		long result = 0; 

		for(int i=0; i<E; i++) {
			if(find(edges[i].s) != find(edges[i].e)) {
				union(edges[i].s, edges[i].e);
				result += edges[i].cost;
			}
		}
		
		System.out.println(result);
	}
	
	public static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int cost;
		
		public Edge(int s, int e, int c){
			this.s = s;
			this.e = e;
			this.cost = c;
		}
		
		@Override 
		public int compareTo(Edge e) {
			return this.cost-e.cost;
		}
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
}
