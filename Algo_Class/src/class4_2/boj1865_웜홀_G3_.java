package class4_2;

import java.util.*;
import java.io.*;

public class boj1865_웜홀_G3_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); // 1~5
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			
			int N = Integer.parseInt(st.nextToken()); // 지점 수 1~500
			int M = Integer.parseInt(st.nextToken()); // 도로 수 1~2500
			int W = Integer.parseInt(st.nextToken()); // 웜홀 개수 1~200
			
			ArrayList<Edge> edge_list = new ArrayList<Edge>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				edge_list.add(new Edge(S, E, T)); // 방향 X
				edge_list.add(new Edge(E, S, T));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = -Integer.parseInt(st.nextToken());
				
				edge_list.add(new Edge(S, E, T)); // 방향 O
			}
			
			int[] distance = new int[N+1];
			boolean hasCycle = false; 

			for(int s=1; s<=N; s++) { // 시작점
				System.out.println(s);
				Arrays.fill(distance, Integer.MAX_VALUE);
				distance[s] = 0;
				
				System.out.println(Arrays.toString(distance));
				
				for(int i=1; i<N; i++) {
					for(int j=0; j<M; j++) {
						Edge e = edge_list.get(j);
						if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e]>distance[e.s]+e.w) {
							distance[e.e] = distance[e.s]+e.w;
						}
					}
				}
				System.out.println(Arrays.toString(distance));
				System.out.println();  

				// 음수 사이클 유무 확인 
				for(int j=0; j<M; j++) {
					Edge e = edge_list.get(j);
					if(distance[e.s]!=Integer.MAX_VALUE && distance[e.e]>distance[e.s]+e.w) {
						hasCycle = true;
						break; 
					}
				}
				
				if(hasCycle) break; 
			}
			
			if(hasCycle) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
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
