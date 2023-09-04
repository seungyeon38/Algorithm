package Algorithm;

import java.util.*;
import java.io.*;

public class boj1504_특정한최단경로_dijkstra {
	static ArrayList<Node>[] graph;
	static int N, E; 
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 800
		E = Integer.parseInt(st.nextToken()); // 간선 200000

		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); 
			
			graph[s].add(new Node(e, w));
			graph[e].add(new Node(s, w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
				
		// v1, v2를 지나는 최단거리 
		// 출발(1) -> v1 -> v2 -> 도착(N)
		// 출발 -> v2 -> v1 -> 도착
		int d1 = dijkstra(1, v1);
		int d2 = dijkstra(v1, v2);
		int d3 = dijkstra(v2, N);
		int d4 = dijkstra(1, v2);
//		int d5 = dijkstra(v2, v1);
		int d6 = dijkstra(v1, N);

		if(d1==Integer.MAX_VALUE || d2==Integer.MAX_VALUE || d3==Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		} else if(d4==Integer.MAX_VALUE || d6==Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
				
		System.out.println(Math.min(d1+d2+d3, d4+d2+d6));
	}
	
	public static class Node{
		int e; 
		int w; 
		
		Node(int e, int w){
			this.e = e; 
			this.w = w;
		}
	}
	
	public static int dijkstra(int s, int e) {
		visited = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[s] = 0; 
		
		for(int i=0; i<N; i++){
			// 최솟값을 가진 인덱스 찾기  
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j]; 
					min_idx = j;
				}
			}
			
			visited[min_idx] = true; 
			if(min_idx == e) break;
			
			// 이 인덱스를 거치는 경우 생각해서 업데이트 
			for(Node n : graph[min_idx]) {
				if(n.w+dist[min_idx] < dist[n.e]) {
					dist[n.e] = n.w+dist[min_idx];
				}
			}
		}
		
		return dist[e];
	}
}
