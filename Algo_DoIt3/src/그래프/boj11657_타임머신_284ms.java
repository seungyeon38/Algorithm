package 그래프;

import java.util.*;
import java.io.*;

public class boj11657_타임머신_284ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 1~500
		int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수 1~6000
		Edge[] edges = new Edge[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // -10000~10000
			
			edges[i] = new Edge(A, B, C);
		}
		
		long[] distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<M; j++) {
				Edge edge = edges[j];
				
				
				if(distance[edge.s]!=Integer.MAX_VALUE && distance[edge.e]>distance[edge.s]+edge.w) {
					distance[edge.e] = distance[edge.s]+edge.w;
				}
			}
		}
		
		boolean hasCycle = false;
		for(int j=0; j<M; j++) {
			Edge edge = edges[j];
			
			if(distance[edge.s]!=Integer.MAX_VALUE && distance[edge.e]>distance[edge.s]+edge.w) {
				hasCycle = true; 
				break; 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(hasCycle) sb.append("-1");
		else {
			for(int i=2; i<=N; i++) {
				if(distance[i] != Integer.MAX_VALUE) sb.append(distance[i]).append("\n");
				else sb.append("-1\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static class Edge{
		int s;
		int e;
		int w;
		
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
}
