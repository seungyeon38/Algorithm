package f_그래프;

import java.util.*;
import java.io.*;

public class boj11657_타임머신_벨만포드_288ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 1~500
		int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수 1~6000
		
		Edge[] edges = new Edge[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()); // 시작도시 1~N
			int B = Integer.parseInt(st.nextToken()); // 도착도시 1~N
			int C = Integer.parseInt(st.nextToken()); // 이동 시간 -10000~10000
			
			edges[i] = new Edge(A, B, C);
		}
		
		long[] distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0; // 시작점 
		
		for(int i=1; i<N; i++) { // N-1번 반복 
			for(int j=0; j<M; j++) {
				Edge e = edges[j];
				
				if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e]>distance[e.s]+e.w) {
					distance[e.e] = distance[e.s]+e.w;
				}
			}
		}
		
		// 음수 사이클 판별 
		boolean hasCycle = false; 
		for(int j=0; j<M; j++) {
			Edge e = edges[j];
			
			if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e]>distance[e.s]+e.w) {
				hasCycle = true; 
				break;
			}
		}
		
		if(hasCycle) System.out.println("-1");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<=N; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(distance[i]).append("\n");
				}
			}
			
			System.out.println(sb.toString());
		}
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
