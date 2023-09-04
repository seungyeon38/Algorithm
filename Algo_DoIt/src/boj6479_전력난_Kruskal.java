package Algorithm;

import java.util.*;
import java.io.*;

public class boj6479_전력난_Kruskal {
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str; 
		StringBuilder sb = new StringBuilder();
		
		while(!(str = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(str);
			int m = Integer.parseInt(st.nextToken()); // 집의 수 200000
			int n = Integer.parseInt(st.nextToken()); // 길의 수 200000
			
			int total = 0; 
			
			Edge[] edge_list = new Edge[n];

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()); 
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken()); 
				int z = Integer.parseInt(st.nextToken());
				
				total += z; 
				edge_list[i] = new Edge(x, y, z);
			}
			
			Arrays.sort(edge_list);
			
			parent = new int[m];
			for(int i=0; i<m; i++) {
				parent[i] = i;
			}
			
			boolean[] visited = new boolean[m];
			int sum = 0; 
			
			for(int i=0; i<n; i++) {
				Edge e = edge_list[i];
				if(find(e.s) != find(e.e)) { // 사이클X
					union(e.s, e.e);
					sum += e.w;
				}
			}
			
			sb.append(total-sum).append("\n");
		}
		
		System.out.println(sb.toString());
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
		if(n == parent[n]) return n;
		
		return parent[n] = find(parent[n]);
	}
}
