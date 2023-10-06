package 벨만포드;

import java.util.*;
import java.io.*;

public class boj11657_벨만포드_304ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 1~500
		int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수 1~6000
		
		ArrayList<Edge> edge_list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // -1000~1000
			
			edge_list.add(new Edge(s, e, w));
		}
		
		long[] distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		for(int i=0; i<N; i++) {
			for(Edge e : edge_list) {
				if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e] > distance[e.s]+e.w) {
					distance[e.e] = distance[e.s]+e.w;
				}
			}
		}
		
		boolean hasCycle = false; 
		for(Edge e : edge_list) {
			if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e] > distance[e.s]+e.w) {
				hasCycle = true;  
			}
		}
		
		if(hasCycle) System.out.println("-1");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i=2; i<=N; i++) {
				sb.append(distance[i]==Integer.MAX_VALUE ? "-1" : distance[i]).append("\n");
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
