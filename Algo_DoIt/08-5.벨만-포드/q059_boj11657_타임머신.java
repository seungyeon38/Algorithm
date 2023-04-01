package Algorithm;

import java.util.*;
import java.io.*;

public class q059_boj11657 {
	static Edge edges[];
	static long distance[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시 500
		int M = Integer.parseInt(st.nextToken()); // 버스 6000
		edges = new Edge[M+1];
		distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(A, B, C);
		}
		
		distance[1] = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<M; j++) {
				Edge e = edges[j];
				
				if(distance[e.sp]!=Integer.MAX_VALUE && distance[e.ep]>distance[e.sp]+e.t) {
					distance[e.ep] = distance[e.sp]+e.t;
				}
			}
		}
		
		boolean hasmCycle = false; 
		
		for(int i=0; i<M; i++) {
			Edge e = edges[i];
			
			if(distance[e.sp]!=Integer.MAX_VALUE && distance[e.ep]>distance[e.sp]+e.t) {
				hasmCycle = true;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(!hasmCycle) {
			for(int i=2; i<=N; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					sb.append("-1").append("\n");
				} else {
					sb.append(distance[i]).append("\n");
				}
			}
			
			System.out.println(sb.toString());
		} else {
			System.out.println("-1");
		}
	}
	
	public static class Edge{
		int sp;
		int ep;
		int t;
		
		Edge(int sp, int ep, int t){
			this.sp = sp;
			this.ep = ep;
			this.t = t;
		}
	}
}
