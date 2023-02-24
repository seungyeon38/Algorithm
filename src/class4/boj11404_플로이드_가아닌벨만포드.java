package class4;

import java.util.*;
import java.io.*;

public class boj11404_플로이드_가아닌벨만포드 {
	static ArrayList<Edge> edge_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 2~100
		int m = Integer.parseInt(br.readLine()); // 1~100000
		int INF = 10000001; 
		
		edge_list = new ArrayList<Edge>();
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken());
			
			edge_list.add(new Edge(s,e,w));
		}
		
		int[][] distance = new int[n+1][n+1];
		
		for(int s=1; s<=n; s++) { // 100
			int[] temp_distance = distance[s];
			Arrays.fill(temp_distance, INF);
			temp_distance[s] = 0;
			
			for(int i=1; i<n; i++) { // 100 
				for(Edge e : edge_list) { // 100000
					if(temp_distance[e.s] != INF && temp_distance[e.e] > temp_distance[e.s] + e.w) {
						temp_distance[e.e] = temp_distance[e.s] + e.w;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == INF) sb.append("0").append(" ");
				else sb.append(distance[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Edge{
		int s;
		int e;
		int w; // 100000
		
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
}
