package 벨만포드;

import java.util.*;
import java.io.*;

public class boj11657_타임머신_304ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 1~500
		int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수 1~6000
		ArrayList<Edge> edge_list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 1~N
			int B = Integer.parseInt(st.nextToken()); // 1~N
			int C = Integer.parseInt(st.nextToken()); // -10000~10000
			
			edge_list.add(new Edge(A, B, C));
		}
		
		long[] distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		for(int i=0; i<N; i++) {
			for(Edge edge : edge_list) {
				if(distance[edge.s]!=Integer.MAX_VALUE && distance[edge.e] > distance[edge.s]+edge.c) {
					distance[edge.e] = distance[edge.s]+edge.c;
				}
			}
		}
		
		boolean hasCycle = false; 
		for(Edge edge : edge_list) {
			if(distance[edge.s]!=Integer.MAX_VALUE && distance[edge.e] > distance[edge.s]+edge.c) {
				hasCycle = true; 
			}
		}
		
		if(hasCycle) System.out.println("-1");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<=N; i++) {
				if(distance[i]!=Integer.MAX_VALUE) sb.append(distance[i]).append("\n");
				else sb.append("-1\n");
			}
			
			System.out.println(sb.toString());
		}
	}
	
	public static class Edge{
		int s;
		int e;
		int c;
		
		Edge(int s, int e, int c){
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}
}
