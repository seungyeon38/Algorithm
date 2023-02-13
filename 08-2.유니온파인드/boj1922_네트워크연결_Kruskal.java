package Algorithm;

import java.util.*;
import java.io.*;

public class boj1922_네트워크연결_Kruskal {
	static int[] parent; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수 1000
		int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선 수 100000
		
		Edge[] edge_list = new Edge[M];
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			edge_list[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edge_list);
		
		// union
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		int weight = 0;
		for(int i=0; i<M; i++) {
			Edge edge = edge_list[i];
			
			if(find(edge.s) != find(edge.e)) { // 사이클이 생기지 않으면 
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
			return this.w-e.w;
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
