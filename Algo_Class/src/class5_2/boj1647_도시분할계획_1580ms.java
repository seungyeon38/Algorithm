package class5_2;

import java.util.*;
import java.io.*;

public class boj1647_도시분할계획_1580ms {
	static int[] parents; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집의 개수 2~100000
		int M = Integer.parseInt(st.nextToken()); // 길의 개수 1~1000000
		ArrayList<Edge> edges = new ArrayList<Edge>();
 		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
 		
 		Collections.sort(edges);

 		parents = new int[N+1];
 		for(int i=1; i<=N; i++) {
 			parents[i] = i;
 		}
 		
 		int result = 0; 
 		int max = 0;
 		for(Edge edge : edges) {
 			if(find(edge.s) != find(edge.e)) {
 				result += edge.w;
 				max = Math.max(max, edge.w);
 				union(edge.s, edge.e);
 			}
 		}
 		
 		System.out.println(result-max);
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
			return this.w-e.w;
		}
	}
}
