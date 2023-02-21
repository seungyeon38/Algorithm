package class4;

import java.util.*;
import java.io.*;

public class boj1865_웜홀 {
	static ArrayList<Edge> edge_list; 
	static int N, M, W;
	static int INF;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); // 5
		INF = 25000001;
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 500
			M = Integer.parseInt(st.nextToken()); // 2500
			W = Integer.parseInt(st.nextToken()); // 200
			edge_list = new ArrayList<Edge>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); // 시작 
				int E = Integer.parseInt(st.nextToken()); // 끝 
				int T = Integer.parseInt(st.nextToken()); // 시간 10000

				edge_list.add(new Edge(S, E, T)); 
				edge_list.add(new Edge(E, S, T)); 
			}
			
			for(int i=M, size=M+W; i<size; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); // 시작 
				int E = Integer.parseInt(st.nextToken()); // 끝 
				int T = Integer.parseInt(st.nextToken()); // 시간 10000
				
				edge_list.add(new Edge(S, E, -T)); 
			}
			
			boolean flag = false; 
			
			for(int i=1; i<=N; i++) {
				if(bellman(i)) {
					flag = true; 
					break; 
				} 
			}
			
			if(flag) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
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
	
	public static boolean bellman(int s) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, INF);
		distance[s] = 0;
		
		boolean flag = false; 
		
		for(int i=1; i<N; i++) {
			flag = false;
			
			for(Edge edge : edge_list) {
				if(distance[edge.s] != INF && distance[edge.e] > distance[edge.s]+edge.w) {
					distance[edge.e] = distance[edge.s]+edge.w;
					flag = true; 
				}
			}
			
			if(!flag) break; 
		}
		
		if(flag) {
			for(Edge edge : edge_list) {
				if(distance[edge.s] != INF && distance[edge.e] > distance[edge.s]+edge.w) {
					return true; 
				}
			}
		}
		
		return false; 
	}
}
